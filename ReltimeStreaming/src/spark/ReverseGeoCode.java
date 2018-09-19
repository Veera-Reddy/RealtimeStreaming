package spark;

import twitter4j.*;
import twitter4j.Twitter;

/**
 * Given a latitude and a longitude, searches for up to 20 places that can be used as a place_id when updating a status.
 *
 * @author Veera
 */
public final class ReverseGeoCode {
    /**
     * Usage: java spark.ReverseGeoCode [latitude] [longitude]
     *
     * @param args message
     * @throws TwitterException 
     */
    public static void main(String[] args) throws TwitterException {
        if (args.length < 2) {
            System.out.println("Usage: java spark.ReverseGeoCode [latitude] [longitude]");
            System.exit(-1);
        }
        
    		spark.Twitter.Authenticate();
    		
    		String latitude = "";
    		String longitude = "";
        
            Twitter twitter = new TwitterFactory().getInstance();
            GeoQuery query = new GeoQuery(new GeoLocation(Double.parseDouble(latitude), Double.parseDouble(longitude)));
            ResponseList<Place> places = twitter.reverseGeoCode(query);
            if (places.size() == 0) {
                System.out.println("No location associated with the specified lat/lang");
            } else {
                for (Place place : places) {
                    System.out.println("id: " + place.getId() + " name: " + place.getFullName());
                    Place[] containedWithinArray = place.getContainedWithIn();
                    if (containedWithinArray != null && containedWithinArray.length != 0) {
                        System.out.println("  contained within:");
                        for (Place containedWithinPlace : containedWithinArray) {
                            System.out.println("  id: " + containedWithinPlace.getId() + " name: " + containedWithinPlace.getFullName());
                        }
                    }
                }
            }
            System.exit(0);
     
    }
}