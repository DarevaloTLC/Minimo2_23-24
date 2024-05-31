package edu.upc.dsa;

import edu.upc.dsa.models.FormData;
import javax.ws.rs.core.Response;

public interface FormResource {
    Response submitForm(FormData formData);
}