package com.example.ReihanHeriantonoCovid;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ReihanHeriantonoCovid.ApiInternet.ApiData;
import com.example.ReihanHeriantonoCovid.ApiInternet.ApiServicee;
import com.example.ReihanHeriantonoCovid.Pembantu.GetDataRS;
import com.example.ReihanHeriantonoCovid.Pembantu.PembantuRS;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentHome#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentRS extends Fragment {
    private RecyclerView recyclerView;
    RecyclerView.Adapter recyclerViewAdapter;
    LinearLayout listdata;
    TextView Judul;
    ApiServicee mapiInterface;
    Gson gson;
    String displayResponse = "";
    // Type type = new TypeToken<List<GetRepository>>(){}.getType();







    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentRS() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentHome.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentHome newInstance(String param1, String param2) {
        FragmentHome fragment = new FragmentHome();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);


        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragmenthospital, container, false);


        recyclerView = view.findViewById(R.id.recyclerViewRumahSakit);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        mapiInterface = ApiData.getClient().create(ApiServicee.class);
        refresh();


        return view;
    }

    public void refresh()
    {
        mapiInterface = ApiData.getClient().create(ApiServicee.class);

        Call<GetDataRS> call = mapiInterface.getRumahSakit();

        call.enqueue(new Callback<GetDataRS>() {
            @Override
            public void onResponse(Call<GetDataRS> call, Response<GetDataRS> response) {
                GetDataRS mdatars= response.body();
                System.out.println(mdatars.status);
                List<GetDataRS.DataRS> dataRSList =  mdatars.datars;
                System.out.println(response.body());
                recyclerViewAdapter = new PembantuRS(getContext(), dataRSList);
                recyclerView.setAdapter(recyclerViewAdapter);
            }

            @Override
            public void onFailure(Call<GetDataRS> call, Throwable t) {
                                                System.out.println("gagal"); System.out.println(t.getMessage());
            }





        });

    }





}