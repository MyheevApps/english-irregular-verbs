package ru.max.irvefree.ui.test;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import ru.max.irvefree.R;

public class LevelAdapter extends BaseAdapter {

    public LevelAdapter(List<String> lvList) {
        this.lvList = lvList;
    }

    private List<String> lvList;

    @Override
    public int getCount() {
        return lvList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        View view;

        if(convertView == null) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_items,parent,false);
        }
        else {
            view = convertView;
        }

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position == 7) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=ru.max.irvi"));
                    parent.getContext().startActivity(intent);
                } else {
                    Intent intent = new Intent(parent.getContext(), PageTest.class);
                    intent.putExtra("LEVEL", lvList.get(position));
                    intent.putExtra("LEVEL_ID", position + 1);
                    parent.getContext().startActivity(intent);
                }
            }
        });
        ((TextView) view.findViewById(R.id.tvLv)).setText(lvList.get(position));

        return view;
    }
}
