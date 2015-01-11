package com.samsullivan.orator.model;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.samsullivan.orator.R;

import java.util.List;

public class SpeechAdapter extends RecyclerView.Adapter<SpeechAdapter.ViewHolder>{

    private List<Speech> speeches;
    private int rowLayout;

    public SpeechAdapter(List<Speech> speeches, int rowLayout, Context context) {
        this.speeches = speeches;
        this.rowLayout = rowLayout;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(rowLayout, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Speech speech = speeches.get(i);
        viewHolder.speechText.setText(speech.text);
    }

    @Override
    public int getItemCount() {
        return speeches == null ? 0 : speeches.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView speechText;

        public ViewHolder(View itemView) {
            super(itemView);
            speechText = (TextView) itemView.findViewById(R.id.speechText);
        }

    }
}
