package damc.castro.com.android.tropicalfruitandveg.NetworkTests;

import org.junit.Assert;
import org.junit.Test;

import damc.castro.com.android.tropicalfruitandveg.Network.BaseRequest;
import damc.castro.com.android.tropicalfruitandveg.Network.KRequests;

public class RequestTests {

    KRequests req = new KRequests();

    @Test
    public void testNetworkRequest() {
        Assert.assertNotNull("Null Response, please check the request", req.makeRequest(BaseRequest.SEARCH_REQUEST,"Mango"));
        Assert.assertNotNull("Null Response, please check the request", req.makeRequest(BaseRequest.SEARCH_REQUEST,""));
    }
}
