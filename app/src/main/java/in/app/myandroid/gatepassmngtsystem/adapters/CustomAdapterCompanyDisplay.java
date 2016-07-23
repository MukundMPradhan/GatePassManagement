package in.app.myandroid.gatepassmngtsystem.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import in.app.myandroid.gatepassmngtsystem.R;
import in.app.myandroid.gatepassmngtsystem.model.Company;

/**
 * Created by mukund on 17/7/16.
 */

public class CustomAdapterCompanyDisplay extends BaseAdapter {

    private ArrayList<Company> companies;
    private LayoutInflater layoutInflater;
    Context context;


    public CustomAdapterCompanyDisplay(Context context, ArrayList<Company> companies) {
        this.companies = companies;
        layoutInflater = LayoutInflater.from(context);
        this.context=context;
    }

    @Override
    public int getCount() {
        return companies.size();
    }

    @Override
    public Object getItem(int position) {
        return companies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.layout_display_company_list_item, parent, false);
        }


        final TextView txtCompName = (TextView) convertView.findViewById(R.id.tvLayoutCompName);
        // TextView txtCompName = (TextView) convertView.findViewById(R.id.tvLayoutCompName);
        final TextView txtCompAdd = (TextView) convertView.findViewById(R.id.tvLayoutCompAddress);
        TextView txtContactPerson = (TextView) convertView.findViewById(R.id.tvLayoutContactPerson);
        TextView txtContactNo = (TextView) convertView.findViewById(R.id.tvLayoutContactNo);
        ImageView imgDelete = (ImageView) convertView.findViewById(R.id.imgLayoutDelete);
        ImageView imgEdit = (ImageView) convertView.findViewById(R.id.imgLayoutEdit);

        Company company = companies.get(position);

        txtCompName.setText(company.getCompName());
        txtCompAdd.setText(company.getCompAdd());
        txtContactPerson.setText(company.getContactPerson());
        txtContactNo.setText(company.getContactNo());
        imgDelete.setVisibility(View.VISIBLE);
        imgEdit.setVisibility(View.VISIBLE);

        imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Are you want to delete the " + companies.get(position).getCompName(), Toast.LENGTH_SHORT).show();
            }
        });

        imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context, "You Clicked the edit Button", Toast.LENGTH_SHORT).show();
//                txtCompName.setText(companies.get(position).getCompName());
//                txtCompName.setText(companies.get(position).getCompAdd());
//                txtCompName.setText(companies.get(position).getContactPerson());
//                txtCompName.setText(companies.get(position).getContactNo());
//                txtCompName.requestFocus();
            }
        });

        return convertView;
    }
}
