package com.example.demojooq.controller;


import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.jooq.generated.Tables.TAG_FINANCE;
import static org.jooq.generated.Tables.TRANSACTIONS;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/transactions")
public class TransactionController {
  private final DSLContext context;


  @GetMapping
  public String detail(){
    Result<Record> result = context
          .select()
          .from(TRANSACTIONS)
          .join(TAG_FINANCE).on(TRANSACTIONS.TAG_ID.eq(TAG_FINANCE.ID))
          .fetch();

    return result.toString();
  }
}
