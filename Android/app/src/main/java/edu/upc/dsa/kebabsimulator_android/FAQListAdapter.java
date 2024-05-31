package edu.upc.dsa.kebabsimulator_android;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.upc.dsa.kebabsimulator_android.models.FAQ;

public class FAQListAdapter extends RecyclerView.Adapter<FAQListAdapter.FaqViewHolder> {
    private List<FAQ> faqList;

    public void setData(List<FAQ> faqList) {
        this.faqList = faqList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FaqViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_faq, parent, false);
        return new FaqViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FaqViewHolder holder, int position) {
        FAQ faq = faqList.get(position);
        holder.questionTextView.setText(faq.getF());
        holder.answerTextView.setText(faq.getQ().toString());
    }

    @Override
    public int getItemCount() {
        return faqList != null ? faqList.size() : 0;
    }

    public static class FaqViewHolder extends RecyclerView.ViewHolder {
        TextView questionTextView;
        TextView answerTextView;

        public FaqViewHolder(@NonNull View itemView) {
            super(itemView);
            questionTextView = itemView.findViewById(R.id.questionTextView);
            answerTextView = itemView.findViewById(R.id.answerTextView);
        }
    }
}