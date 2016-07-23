package layout;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import in.app.myandroid.gatepassmngtsystem.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentSearchHeader extends Fragment {
    private TextView tvRefNo, tvFastName, tvLastName, tvPassType, tvStatus;
    private EditText txtRefNo, txtFastName, txtLastName;
    private Spinner spinnerPassType, spinnerStatus;

    ArrayAdapter adapterPassType, adapterStatus;


    public FragmentSearchHeader() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_search_header, container, false);
        tvRefNo = (TextView) view.findViewById(R.id.tvSHRefNo);
        tvFastName = (TextView) view.findViewById(R.id.tvSHFastName);
        tvLastName = (TextView) view.findViewById(R.id.tvSHLastName);
        tvPassType = (TextView) view.findViewById(R.id.tvSHPassType);
        tvStatus = (TextView) view.findViewById(R.id.tvSHStatus);
        txtRefNo = (EditText) view.findViewById(R.id.etSHRefNo);
        txtFastName = (EditText) view.findViewById(R.id.etSHFastName);
        txtLastName = (EditText) view.findViewById(R.id.etSHLastName);
        spinnerPassType = (Spinner) view.findViewById(R.id.spinnerSHPassType);
        spinnerStatus = (Spinner) view.findViewById(R.id.spinnerSHStatus);

        adapterPassType = ArrayAdapter.createFromResource(getActivity(), R.array.passType, R.layout.layout_text_view);
        adapterStatus = ArrayAdapter.createFromResource(getContext(), R.array.status, R.layout.layout_text_view);

        spinnerPassType.setAdapter(adapterPassType);
        spinnerStatus.setAdapter(adapterStatus);


        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }
}
