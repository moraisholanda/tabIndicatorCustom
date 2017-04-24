package com.morais.tabbar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by sergio on 22/04/17.
 */

public class FragmentItem extends Fragment {

    private static final String KEY_INDICATOR_COLOR = "key_indicator_color";
    private static final String KEY_DIVIDER_COLOR = "key_divider_color";
    private static final String KEY_TITLE = "key_title";

  public static FragmentItem newInstance(String title,int indicatorColor,int dividerColor) {

        Bundle args = new Bundle();

        FragmentItem fragment = new FragmentItem();
        args.putString(KEY_TITLE,title);
        args.putInt(KEY_DIVIDER_COLOR,dividerColor);
        args.putInt(KEY_INDICATOR_COLOR,indicatorColor);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_item, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle bundle = getArguments();
        final TextView color = (TextView) view.findViewById(R.id.color);
        if(bundle!=null){

            int indicatorColor = bundle.getInt(KEY_INDICATOR_COLOR);
            color.setText("novo");
            color.setTextColor(indicatorColor);
        }
        Button button = (Button) view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                color.setText("click");
            }
        });

    }
}
