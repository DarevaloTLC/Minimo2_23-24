package edu.upc.dsa;


import edu.upc.dsa.models.FAQ;

import java.util.List;

public interface FAQList {
    public FAQ addFAQ(FAQ faq);
    public FAQ answerFAQ(String id, String answer);
    public List<FAQ> getFAQList();
    int size();
}
