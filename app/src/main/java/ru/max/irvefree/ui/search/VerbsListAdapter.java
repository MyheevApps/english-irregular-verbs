package ru.max.irvefree.ui.search;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

import ru.max.irvefree.R;

public class VerbsListAdapter extends BaseAdapter {

    private Context mContext;
    private List<Verbs> mVerbsList;

    /* SearchView*/
    public void update(ArrayList<Verbs> results)
    {
        mVerbsList = new ArrayList<>();
        mVerbsList.addAll(results);
        notifyDataSetChanged();
    }
    /*Finish searchView*/

    public VerbsListAdapter(Context mContext, List<Verbs> mVerbsList) {
        this.mContext = mContext;
        this.mVerbsList = mVerbsList;
    }

    @Override
    public int getCount() {
        return mVerbsList.size();
    }

    @Override
    public Object getItem(int position) {
        return mVerbsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = View.inflate(mContext, R.layout.row_verbs, null);
        TextView textViewName = (TextView)v.findViewById((R.id.textViewName));
        TextView textViewFirst = (TextView)v.findViewById((R.id.textViewFirst));
        TextView textViewSecond = (TextView)v.findViewById((R.id.textViewSecond));
        TextView textViewThird = (TextView)v.findViewById((R.id.textViewThird));
        /* Установка текста шаблону */
        textViewName.setText(mVerbsList.get(position).getTransfer());
        textViewFirst.setText(mVerbsList.get(position).getFirstFormElementary());
        textViewSecond.setText(mVerbsList.get(position).getSecondFormElementary());
        textViewThird.setText(mVerbsList.get(position).getThirdFormElementary());


        /* Создаем tag глаголов*/
        v.setTag(mVerbsList.get(position).getId());

        return v;
    }
}