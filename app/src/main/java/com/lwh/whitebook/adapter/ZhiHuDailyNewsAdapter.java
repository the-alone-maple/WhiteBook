package com.lwh.whitebook.adapter;

import android.content.Context;
import android.support.v4.view.LayoutInflaterFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.aspsine.irecyclerview.IRecyclerView;
import com.aspsine.irecyclerview.universaladapter.ViewHolderHelper;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.lwh.whitebook.R;
import com.lwh.whitebook.beans.ZhiHuDailyNews;
import com.lwh.whitebook.interfaze.OnRecyclerItemClickListener;

import java.util.List;

import static com.lwh.whitebook.R.layout.home_list_item_normal;
import static com.lwh.whitebook.R.layout.home_list_item_with_image;
import static com.lwh.whitebook.R.layout.preference;

/**
 * Created by Administrator on 2017/3/3.
 */

public class ZhiHuDailyNewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context ctx;//context
    private List<ZhiHuDailyNews.Question> questions;//Data List
    private LayoutInflater inflater;

    private OnRecyclerItemClickListener mListener;


    private static final int TYPE_NORMAL = 0;
    private static final int TYPE_FOOTER = 1;

    /**
     * ZhiHuDailyNewsAdapter constructor
     *
     * @param ctx
     * @param list
     */
    public ZhiHuDailyNewsAdapter(Context ctx, List<ZhiHuDailyNews.Question> list) {
        this.ctx = ctx;
        this.questions = list;
        this.inflater = LayoutInflater.from(ctx);
    }

    /**
     * @param mListener
     */
    public void setOnReCyclerItemClickListener(OnRecyclerItemClickListener mListener) {
        this.mListener = mListener;
    }

    @Override
    public IRecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE_NORMAL:
                View normal = inflater.inflate(home_list_item_with_image, parent,false);
                return new NormalViewHolder(normal, mListener);
            case TYPE_FOOTER:
                return new FooterViewHolder(inflater.inflate(R.layout.layout_footer, parent,false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        //如果没到滑动到最后
        if (holder instanceof NormalViewHolder && position != questions.size()) {
            ZhiHuDailyNews.Question item = questions.get(position);

            if (item.getImages().get(0) == null) {
                ((NormalViewHolder) holder).itemIv.setImageResource(R.drawable.placeholder);
            } else {
                Glide.with(ctx)
                        .load(item.getImages().get(0))
                        .asBitmap()
                        .placeholder(R.drawable.placeholder)
                        .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                        .error(R.drawable.placeholder)
                        .into(((NormalViewHolder) holder).itemIv);
            }
            ((NormalViewHolder) holder).itemTv.setText(item.getTitle());
        }
    }


    @Override
    public int getItemCount() {
        return questions.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == questions.size()) {
            return TYPE_FOOTER;
        }
        return TYPE_NORMAL;
    }

    static class NormalViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView itemTv;
        private ImageView itemIv;
        private OnRecyclerItemClickListener listener;

        public NormalViewHolder(View itemView, OnRecyclerItemClickListener listener) {
            super(itemView);
            this.listener = listener;
            this.itemTv = (TextView) itemView.findViewById(R.id.home_item_tv);
            this.itemIv = (ImageView) itemView.findViewById(R.id.home_item_iv);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            if (listener != null) {
                listener.onRecycleItemClick(v, getLayoutPosition());
            }
        }
    }

    static class FooterViewHolder extends RecyclerView.ViewHolder {

        public FooterViewHolder(View itemView) {
            super(itemView);
        }
    }
}
