package damc.castro.com.android.tropicalfruitandveg.NetworkTests;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import damc.castro.com.android.tropicalfruitandveg.Network.Requests;

public class RequestTests {

    Requests req = new Requests();

    @Test
    public void testNetworkRequest() throws IOException {
//        Assert.assertNotNull("Null Response, please check the request", req.getSearchFruits("876543"));
        Assert.assertNotNull("Null Response, please check the request", req.makeRequest(Requests.SEARCH_REQUEST,"Mango"));
        Assert.assertNotNull("Null Response, please check the request", req.makeRequest(Requests.SEARCH_REQUEST,""));
    }
}
