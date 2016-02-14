package com.androidtutorialshub.recyclerviewtutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.androidtutorialshub.recyclerviewtutorial.Adapter.BookAdapter;
import com.androidtutorialshub.recyclerviewtutorial.Helper.ItemDividerDecoration;
import com.androidtutorialshub.recyclerviewtutorial.Model.Book;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Book> bookList = new ArrayList<>();
    private RecyclerView recyclerView;
    private BookAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new BookAdapter(bookList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new ItemDividerDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);

        initBookData();
    }

    private void initBookData() {
        Book book = new Book("Hello Android", "Ed Burnette");
        bookList.add(book);

        book = new Book("Beginning Android 3", "Mark Murphy");
        bookList.add(book);

        book = new Book("Unlocking Android", " W. Frank Ableson");
        bookList.add(book);

        book = new Book("Android Tablet Development", "Wei Meng Lee");
        bookList.add(book);

        book = new Book("Android Apps Security", "Sheran Gunasekera");
        bookList.add(book);

        mAdapter.notifyDataSetChanged();
    }
}
