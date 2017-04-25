package com.oshi.searchtoolbarapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.oshi.libsearchtoolbar.SearchAnimationToolbar;

public class ExampleFragment extends Fragment implements SearchAnimationToolbar.OnSearchQueryChangedListener {

    private SearchAnimationToolbar toolbar;
    private TextView searchText;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_example, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        toolbar = (SearchAnimationToolbar) view.findViewById(R.id.toolbar);
        toolbar.setSupportActionBar((AppCompatActivity) getActivity());
        toolbar.setOnSearchQueryChangedListener(ExampleFragment.this);

        ((AppCompatActivity)getActivity()).getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_24dp);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        searchText = (TextView) view.findViewById(R.id.searchText);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_search, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int itemId = item.getItemId();

        if (itemId == R.id.action_search) {
            toolbar.onSearchIconClick();
            return true;
        } else if (itemId == android.R.id.home) {
            getActivity().onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSearchCollapsed() {
        searchText.setText(R.string.collapsed);
    }

    @Override
    public void onSearchQueryChanged(String query) {
        searchText.setText("Searching: " + query);
    }

    @Override
    public void onSearchExpanded() {
        searchText.setText(R.string.expanded);
    }

    @Override
    public void onSearchSubmitted(String query) {
        searchText.setText(getString(R.string.submitted, query));
    }
}
