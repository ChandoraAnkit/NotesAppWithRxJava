package com.chandora.androidy.notesappwithrxjava.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chandora.androidy.notesappwithrxjava.R;
import com.chandora.androidy.notesappwithrxjava.network.model.Note;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NoteViewHolder> {

    private static Context context;
    private ArrayList<Note> notesList;

    public NotesAdapter(Context context, ArrayList<Note> notesList) {

        this.context = context;
        this.notesList = notesList;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_note_row, parent, false);
        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int pos) {

        holder.bind(notesList.get(pos));

    }

    @Override
    public int getItemCount() {
        return notesList == null ? 0 : notesList.size();
    }

    static class NoteViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.dot)
        TextView dotTv;

        @BindView(R.id.note)
        TextView notetv;

        @BindView(R.id.timestamp)
        TextView timestampTv;

        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(itemView);
        }

        public void bind(Note note) {

            dotTv.setText(Html.fromHtml("&#8226;"));
            dotTv.setTextColor(getRandomColor("400"));
            notetv.setText(note.getNote());
            timestampTv.setText(formatDate(note.getTimestamp()));
        }
    }

    private static int getRandomColor(String typeColor) {

        int returnColor = Color.GRAY;
        int arrayId = context.getResources().getIdentifier("mdcolor_" + typeColor, "array", context.getPackageName());

        if (arrayId != 0) {
            TypedArray colors = context.getResources().obtainTypedArray(arrayId);
            int index = (int) (Math.random() * colors.length());
            returnColor = colors.getColor(index, Color.GRAY);
            colors.recycle();
        }
        return returnColor;
    }

    private static String formatDate(String dateString) {
        try {

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = date = simpleDateFormat.parse(dateString);
            SimpleDateFormat sdf = new SimpleDateFormat("MMM d");
            return simpleDateFormat.format(date);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }
}
