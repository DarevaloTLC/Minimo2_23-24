package edu.upc.dsa;

import edu.upc.dsa.models.FAQ;
import org.apache.log4j.Logger;

import java.util.LinkedList;
import java.util.List;

public class FAQListImpl implements FAQList{
    private static FAQListImpl instance;
    protected List<FAQ> faqList;
    final static Logger logger = Logger.getLogger(FAQListImpl.class);
    private FAQListImpl() {this.faqList = new LinkedList<FAQ>();}

    public static FAQListImpl getInstance() {
        if (instance == null) {
            instance = new FAQListImpl();}
        return instance;
    }
    public int size(){
        int ret = this.faqList.size();
        logger.info("size" + ret);
        return ret;
    }
    public FAQ addFAQ(FAQ faq){
        logger.info("addFAQ" + faq);
        this.faqList.add(faq);
        logger.info("Added FAQ:" + faq);
        return faq;
    }
    public FAQ answerFAQ(String id, String answer){
        FAQ retfaq = new FAQ();
        for(FAQ faq : this.faqList){
            if(faq.getId().equals(id)){
                faq.addQ(answer);
                retfaq = faq;
            }
        }
        return retfaq;
    }
    public List<FAQ> getFAQList(){
        logger.info("getFAQList");
        return this.faqList;
    }
}
