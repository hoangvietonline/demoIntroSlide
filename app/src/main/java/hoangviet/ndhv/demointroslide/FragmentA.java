package hoangviet.ndhv.demointroslide;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class FragmentA extends Fragment {
    RecyclerView recyclerView;
    phim_hd_Adapter adapter;
    ArrayList<phim_hd>phim_hdArrayList;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a,container,false);
        recyclerView = view.findViewById(R.id.recyclerView_phim);
        phim_hdArrayList = new ArrayList<>();
        ReadJson("https://api.androidhive.info/json/movies_2017.json");

        adapter = new phim_hd_Adapter(phim_hdArrayList,getActivity());
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(),3);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setAdapter(adapter);
        return view;
    }


    public void ReadJson(String url){
        RequestQueue queue = Volley.newRequestQueue(this.getActivity());
        final JsonArrayRequest arrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                String tittle = "";
                String gia = "";
                String hinh = "";
                for (int i = 0 ; i < response.length() ; i++){
                    try {
                        JSONObject object = response.getJSONObject(i);
                        tittle = object.getString("title");
                        gia = object.getString("price");
                        hinh = object.getString("image");
                        phim_hdArrayList.add(new phim_hd(hinh,tittle,gia));
                        Toast.makeText(getActivity(),hinh, Toast.LENGTH_SHORT).show();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
                adapter.notifyDataSetChanged();
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getActivity(), "Lỗi quá đi mak,sửa đi", Toast.LENGTH_SHORT).show();
                    }
                });
        queue.add(arrayRequest);
    }
}
