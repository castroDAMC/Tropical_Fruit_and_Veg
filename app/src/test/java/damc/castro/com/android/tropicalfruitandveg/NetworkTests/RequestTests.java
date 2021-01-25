package damc.castro.com.android.tropicalfruitandveg.NetworkTests;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import damc.castro.com.android.tropicalfruitandveg.Network.KRequests;

public class RequestTests {

    KRequests req = new KRequests();

    @Test
    public void testNetworkRequest() throws IOException {
        Assert.assertNotNull("Null Response, please check the request", req.makeRequest(KRequests.Companion.getSEARCH_REQUEST(),"Mango"));
        Assert.assertNotNull("Null Response, please check the request", req.makeRequest(KRequests.Companion.getSEARCH_REQUEST(),""));
    }
}
