package de.dpunkt.myaktion.model;

import javax.json.*;
import javax.json.JsonValue.ValueType;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Provider
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DonationListMBR implements MessageBodyReader<List<Donation>> {

    private final Function<JsonValue, Donation> jsonToDonation = value -> {
        Donation donation = new Donation();
        JsonObject object = (JsonObject) value;
        donation.setAmount(object.getJsonNumber("amount").doubleValue());
        donation.setDonorName(object.getString("donorName"));
        return donation;
    };

    @Override
    public boolean isReadable(Class<?> c, Type t, Annotation[] ann, MediaType mt) {
        return true;
    }

    @Override
    public List<Donation> readFrom(Class<List<Donation>> c, Type t,
                                   Annotation[] ann, MediaType mt, MultivaluedMap<String, String> mm,
                                   InputStream is) throws IOException, WebApplicationException {
        JsonReader reader = Json.createReader(is);
        JsonArray values = reader.readArray();
        List<Donation> donations = values.stream().
                filter(v -> v.getValueType() == ValueType.OBJECT).
                map(jsonToDonation).
                collect(Collectors.toList());
        reader.close();
        return donations;
    }

}
