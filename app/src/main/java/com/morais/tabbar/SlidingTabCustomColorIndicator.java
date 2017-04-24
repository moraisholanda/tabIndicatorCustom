package com.morais.tabbar;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sergio on 22/04/17.
 */

public class SlidingTabCustomColorIndicator extends Fragment {

    static class FragmentPageItem {
        private final String title;
        private final int indicatoColor;
        private final int dividerColor;
        private final String quantidadeItens;

        public FragmentPageItem(String title, int indicatoColor, int dividerColor,
                String quantidadeItens) {
            this.title = title;
            this.indicatoColor = indicatoColor;
            this.dividerColor = dividerColor;
            this.quantidadeItens = quantidadeItens;
        }

        Fragment createFragment(){
            return FragmentItem.newInstance(title,indicatoColor,dividerColor);
        }


        public String getTitle() {
            return title;
        }

        public int getIndicatoColor() {
            return indicatoColor;
        }

        public int getDividerColor() {
            return dividerColor;
        }

        public String getQuantidadeItens() {
            return quantidadeItens;
        }
    }

    private SlidingTabLayout slidingTabLayout;
    private ViewPager viewPager;
    private List<FragmentPageItem> tabs = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        tabs.add(new FragmentPageItem("efetivado", Color.GREEN,Color.TRANSPARENT,"2"));
        tabs.add(new FragmentPageItem("tab2", Color.RED,Color.TRANSPARENT,"3"));
        tabs.add(new FragmentPageItem("tab3", Color.BLUE,Color.TRANSPARENT,"4"));
        tabs.add(new FragmentPageItem("tab4", Color.YELLOW,Color.DKGRAY,"5"));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.sliding_tab_layout,container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        viewPager.setAdapter(new SlidingAdapter(getChildFragmentManager()));
        slidingTabLayout = (SlidingTabLayout) view.findViewById(R.id.sliding_tabs);
        slidingTabLayout.setCustomTabView(R.layout.tab_custom,R.id.titulo,R.id.quantidade);
        slidingTabLayout.setViewPager(viewPager);
        slidingTabLayout.setListenerColorIndicatorTab(new SlidingTabLayout.ListenerColorIndicatorTab() {
            @Override
            public int getIndicatorColor(int position) {
                return tabs.get(position).getIndicatoColor();
            }

            @Override
            public int getDividerColor(int position) {
                return tabs.get(position).getDividerColor();
            }
        });

    }

   public class SlidingAdapter extends FragmentStatePagerAdapter{



        public SlidingAdapter(FragmentManager fm) {
            super(fm);
        }

        public String getQuantidadeItens(int position) {
            return tabs.get(position).quantidadeItens;
        }

        @Override
        public Fragment getItem(int position) {
            return tabs.get(position).createFragment();
        }

        @Override
        public int getCount() {
            return tabs.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabs.get(position).getTitle();
        }
    }

}
