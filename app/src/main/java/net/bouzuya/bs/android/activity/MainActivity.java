package net.bouzuya.bs.android.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import net.bouzuya.bs.R;
import net.bouzuya.bs.android.BsApplication;
import net.bouzuya.bs.model.entity.Bs;
import net.bouzuya.bs.model.entity.BsList;
import net.bouzuya.bs.model.presenter.BsPresenter;
import net.bouzuya.bs.model.presenter.BsPresenterFactory;
import net.bouzuya.bs.model.view.BsView;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements BsView {
    @Inject
    BsPresenterFactory bsPresenterFactory;
    private BsPresenter bsPresenter;
    private BsListAdapter bsListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((BsApplication) getApplication()).getComponent().inject(this);
        bsPresenter = bsPresenterFactory.create(this);
        bsListAdapter = new BsListAdapter(BsList.empty());
        RecyclerView bsListView = (RecyclerView) findViewById(R.id.bs_list_view);
        bsListView.setAdapter(bsListAdapter);
        bsListView.setLayoutManager(new LinearLayoutManager(bsListView.getContext()));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bsPresenter = null;
    }

    @Override
    protected void onStart() {
        super.onStart();
        bsPresenter.start();
    }

    @Override
    public void showBsList(BsList bsList) {
        bsListAdapter.changeDataSet(bsList);
        bsListAdapter.notifyDataSetChanged();
    }

    @Override
    public void showLoadException(Throwable throwable) {
        // TODO
    }

    private static class BsListAdapter extends RecyclerView.Adapter<BsListItemViewHolder> {
        private BsList bsList;

        BsListAdapter(BsList bsList) {
            this.bsList = bsList;
        }

        void changeDataSet(BsList bsList) {
            this.bsList = bsList;
        }

        @Override
        public int getItemCount() {
            return this.bsList.size();
        }

        @Override
        public void onBindViewHolder(BsListItemViewHolder holder, int position) {
            Bs bs = this.bsList.get(position);
            holder.contentSummaryTextView.setText(bs.getContent());
            holder.createdAtTextView.setText(bs.getCreatedAt().toString());
        }

        @Override
        public BsListItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View view = layoutInflater.inflate(R.layout.item_bs_list, parent, false);
            return new BsListItemViewHolder(view);
        }
    }

    private static class BsListItemViewHolder extends RecyclerView.ViewHolder {
        TextView createdAtTextView;
        TextView contentSummaryTextView;

        BsListItemViewHolder(View itemView) {
            super(itemView);
            this.createdAtTextView =
                    (TextView) itemView.findViewById(R.id.created_at_text_view);
            this.contentSummaryTextView =
                    (TextView) itemView.findViewById(R.id.content_summary_text_view);
        }
    }
}
