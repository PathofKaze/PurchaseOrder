package com.iss.nus.POSql.POSql.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.iss.nus.POSql.POSql.models.LineItem;

import static com.iss.nus.POSql.POSql.respositories.Queries.*;

import java.util.List;

@Repository
public class LineItemRepository {

    @Autowired
    private JdbcTemplate liRepo;

    public boolean insertLineItem(String orderId, LineItem li) {
        int count = liRepo.update(SQL_INSERT_LINE_ITEM,
            li.getProductId(), orderId, li.getQuantity());
        return 1 == count;
    }

    public boolean insertLineItems(String orderId, List<LineItem> lineItems) {
        for (LineItem li: lineItems)
            if (!insertLineItem(orderId, li))
                return false;
        return true;
    }
    
}