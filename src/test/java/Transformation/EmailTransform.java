//
// File Created by miguel_aguilar on 5/3/2018 2:12 PM
//
package Transformation;

import cucumber.api.Transformer;

public class EmailTransform extends Transformer<String> {

    @Override
    public String transform(String value){
        return value.concat("@ea.com");
    }
}

