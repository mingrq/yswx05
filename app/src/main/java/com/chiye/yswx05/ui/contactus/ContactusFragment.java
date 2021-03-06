package com.chiye.yswx05.ui.contactus;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.chiye.yswx05.R;

import java.util.List;
import java.util.Map;

public class ContactusFragment extends Fragment {
    private ContactusViewModel contactusViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        contactusViewModel =
                ViewModelProviders.of(this).get(ContactusViewModel.class);
        View root = inflater.inflate(R.layout.fragment_contactus, container, false);
        final ListView listView = root.findViewById(R.id.lv_contactus);
        final ContactusAdapter adapter = new ContactusAdapter(getContext());
        listView.setAdapter(adapter);
        contactusViewModel.getContactusEntity(getContext()).observe(this, new Observer<List<Map<String,String>>>() {
            @Override
            public void onChanged(List<Map<String,String>> list) {
                adapter.setList(list);
            }
        });
        return root;
    }
}
