package com.aigner;

import io.netty.handler.codec.http.QueryStringEncoder;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FragmentTest {

  @Test
  public void withQueryParameters() {
    var qse = new QueryStringEncoder("/thePath?email=foo@bar.com");
    qse.addParam("myKey", "myValue");
    assertEquals("/thePath?email=foo@bar.com?myKey=myValue", qse.toString());
  }

  @Test
  public void withQueryParametersAndFragment() {
    var qse = new QueryStringEncoder("/thePath?email=foo@bar.com#fragment");
    qse.addParam("myKey", "myValue");
    assertEquals("/thePath?email=foo@bar.com&myKey=myValue#fragment", qse.toString());
  }

  @Test
  public void withoutQueryParameters() {
    var qse = new QueryStringEncoder("/thePath");
    qse.addParam("myKey", "myValue");
    assertEquals("/thePath?myKey=myValue", qse.toString());
  }

  @Test
  public void withoutQueryParametersButWithFragment() {
    var qse = new QueryStringEncoder("/thePath#fragment");
    qse.addParam("myKey", "myValue");
    assertEquals("/thePath?myKey=myValue#fragment", qse.toString());
  }

}
