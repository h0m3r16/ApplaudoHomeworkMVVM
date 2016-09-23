package com.applaudostudios.applaudohomework.ui.viewmodel;

import java.util.List;

public interface ListViewModelListener<T> {
    void onItemSelected(T item);
    void onDataLoaded(List<T> items);
}
