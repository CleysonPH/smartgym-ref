package br.com.treinaweb.smartgym.api.v1.common.validationgroups;

import javax.validation.GroupSequence;

@GroupSequence({FirstOrder.class, SecondOrder.class, ThirdOrder.class, FourthOrder.class})
public interface ValidationSequence {

}
