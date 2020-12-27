package com.aigner;

import io.netty.handler.codec.http.QueryStringEncoder;
import org.junit.Assert;
import org.junit.Test;

import java.net.URI;

public class QueryStringEncoderTest {

  @Test
  public void existingParameters() throws Exception {
    QueryStringEncoder e = new QueryStringEncoder("/foo?1=1");
    e.addParam("2", "2");
    Assert.assertEquals("/foo?1=1&2=2", e.toString());
    Assert.assertEquals(new URI("/foo??1=1&2=2"), e.toUri());
  }

}
