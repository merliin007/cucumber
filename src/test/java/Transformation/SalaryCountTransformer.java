//
// File Created by miguel_aguilar on 5/3/2018 2:24 PM
//
package Transformation;

import cucumber.api.Transformer;

public class SalaryCountTransformer extends Transformer<Integer> {

    @Override
    public Integer transform(String salary){
        return salary.length();
    }
}
