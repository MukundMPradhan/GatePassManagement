package layout;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import in.app.myandroid.gatepassmngtsystem.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Master_Login extends Fragment {


    public Fragment_Master_Login() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_master_login, container, false);
    }

}
