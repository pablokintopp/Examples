package pablokintopp.com.mvvmtemplate.view.repolist;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import pablokintopp.com.mvvmtemplate.databinding.ItemRepoListBinding;
import pablokintopp.com.mvvmtemplate.model.api.entity.Repo;
import pablokintopp.com.mvvmtemplate.util.RxBus;
import pablokintopp.com.mvvmtemplate.viewmodel.repolist.RepoListItemViewModel;
import pablokintopp.com.mvvmtemplate.viewmodel.repolist.RepoListViewModel;

/**
 * Created by Pablo on 14/03/2018.
 */

public class RepoListAdapter extends RecyclerView.Adapter<RepoListAdapter.RepoListViewHolder>{

    private List<Repo> repos;
    private RxBus rxBus;

    public RepoListAdapter(RxBus rxBus) {
        this.rxBus = rxBus;
        repos = new ArrayList<>();
    }

    public void setRepos(List<Repo> repos) {
        this.repos = repos;
        notifyDataSetChanged();
    }

    public List<Repo> getRepos() {
        return repos;
    }

    @Override
    public RepoListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return RepoListViewHolder.create(LayoutInflater.from(parent.getContext()),parent);
    }

    @Override
    public void onBindViewHolder(RepoListViewHolder holder, int position) {
        holder.bind(new RepoListItemViewModel(holder.itemView.getContext(), rxBus, repos.get(position)));
    }

    @Override
    public int getItemCount() {
        return repos.size();
    }

    static class RepoListViewHolder extends  RecyclerView.ViewHolder {

        static RepoListAdapter.RepoListViewHolder create(LayoutInflater inflater, ViewGroup parent){
             ItemRepoListBinding binding = ItemRepoListBinding.inflate(inflater, parent, false);
             return new RepoListAdapter.RepoListViewHolder(binding);
        }

        private ItemRepoListBinding binding;

        public RepoListViewHolder(ItemRepoListBinding binding){
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(RepoListItemViewModel viewModel){
            binding.setViewModel(viewModel);
            binding.executePendingBindings();
        }
    }
}
