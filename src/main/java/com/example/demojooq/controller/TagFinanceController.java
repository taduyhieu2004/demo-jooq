package com.example.demojooq.controller;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.generated.Tables;
import org.jooq.generated.tables.pojos.TagFinance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/tag-finances")
public class TagFinanceController {
  @Autowired
  DSLContext context;


  @PostMapping
  public String create() {
    context
          .insertInto(Tables.TAG_FINANCE, Tables.TAG_FINANCE.NAME, Tables.TAG_FINANCE.DESCRIPTION)
          .values("haha", "hihi")
          .execute();

    return "ok";

  }

  @GetMapping
  public List<TagFinance> list() {
    return context
          .selectFrom(Tables.TAG_FINANCE)
          .fetchInto(TagFinance.class);
  }

}
