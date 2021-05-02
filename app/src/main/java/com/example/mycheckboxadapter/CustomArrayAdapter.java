package com.example.mycheckboxadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class CustomArrayAdapter extends ArrayAdapter<Producte> implements View.OnClickListener {
    private LayoutInflater layoutInflater;

     ArrayList<Integer> llistaProductes;

    public CustomArrayAdapter(Context context, List<Producte> objects)
    {
        super(context, 0, objects);
        layoutInflater = LayoutInflater.from(context);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // holder pattern
        Holder holder = null;
        ImageView avatar;

        if (convertView == null)   {
            holder = new Holder();
            convertView = layoutInflater.inflate(R.layout.listview_row, null);
            holder.setCheckBox((CheckBox) convertView.findViewById(R.id.checkBox));
            holder.setTextViewTitle( convertView.findViewById(R.id.producte_nom));
            holder.setTextViewSubtitle(convertView.findViewById(R.id.producte_descripcio));
            holder.setImageView(convertView.findViewById(R.id.producte_avatar));
            convertView.setTag(holder);
        }
        else {
            holder = (Holder) convertView.getTag();
        }
        // To show the picture of the product: Glide
        avatar = (ImageView) convertView.findViewById(R.id.producte_avatar);
        Producte producte = getItem(position);
        Glide.with(getContext()).load(producte.getFoto()).into(avatar);

        holder.getTextViewTitle().setText(producte.getNomProducte());
        holder.getTextViewSubtitle().setText(producte.getDescripcioProducte());
        holder.getImageView();

        // To manage the CheckBoxes
        holder.getCheckBox().setTag(position);
        holder.getCheckBox().setChecked(producte.isChecked());
        holder.getCheckBox().setOnClickListener(this);

        return convertView;
    }

    @Override
    public void onClick(View v) {
        String message;
        CheckBox checkBox = (CheckBox) v;
        int position = (Integer) v.getTag();
        getItem(position).setChecked(checkBox.isChecked());

        if (ListViewActivity.llistaProductes.get(position).getSelected()) {
            message = ListViewActivity.llistaProductes.get(position).getNomProducte() + " unselected";
            ListViewActivity.llistaProductes.get(position).setSelected(false);
        }
        else {
            message = ListViewActivity.llistaProductes.get(position).getNomProducte() + " selected";
            ListViewActivity.llistaProductes.get(position).setSelected(true);
        }
        Toast.makeText(this.getContext(), message, Toast.LENGTH_SHORT).show();
    }

    static class Holder    {
        TextView textViewTitle;
        TextView textViewSubtitle;
        CheckBox checkBox;
        ImageView foto;

        public TextView getTextViewTitle()  {
            return textViewTitle;
        }
        public void setTextViewTitle(TextView textViewTitle)    {
            this.textViewTitle = textViewTitle;
        }
        public TextView getTextViewSubtitle()     {
            return textViewSubtitle;
        }
        public void setTextViewSubtitle(TextView textViewSubtitle)    {
            this.textViewSubtitle = textViewSubtitle;
        }
        public CheckBox getCheckBox()    {
            return checkBox;
        }
        public void setCheckBox(CheckBox checkBox)     {
            this.checkBox = checkBox;
        }
        public ImageView  getImageView () {
            return foto;
        }
        public void setImageView ( ImageView foto)     {
            this.foto = foto;
        }
    }
}
