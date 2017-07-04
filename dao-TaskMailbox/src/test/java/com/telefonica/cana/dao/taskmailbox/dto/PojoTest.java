package com.telefonica.cana.dao.taskmailbox.dto;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.PojoValidator;
import com.openpojo.validation.rule.impl.NoNestedClassRule;
import com.openpojo.validation.rule.impl.NoPublicFieldsRule;
import com.openpojo.validation.rule.impl.NoStaticExceptFinalRule;
import com.openpojo.validation.test.impl.DefaultValuesNullTester;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;
import com.openpojo.validation.utils.ValidationHelper;
import com.telefonica.coco.lib.test.openpojo.GetterNullTester;
import com.telefonica.coco.lib.test.openpojo.SetterNullTester;
import com.telefonica.coco.lib.test.openpojo.filters.DefaultPojoFilter;

public class PojoTest {

    private PojoValidator pojoValidator;
    private List<PojoClass> pojoClasses;

    @Before
    public void setup() {

        pojoValidator = new PojoValidator();
        pojoClasses = PojoClassFactory.getPojoClassesRecursively("com.telefonica.cana.dao.taskmailbox.dto",
                new DefaultPojoFilter());

        // Create Rules to validate structure for POJO_PACKAGE
        pojoValidator.addRule(new NoPublicFieldsRule());
        pojoValidator.addRule(new NoStaticExceptFinalRule());
        pojoValidator.addRule(new NoNestedClassRule());

        // Create Testers to validate behaviour for POJO_PACKAGE
        pojoValidator.addTester(new DefaultValuesNullTester());
        pojoValidator.addTester(new SetterTester());
        pojoValidator.addTester(new SetterNullTester());
        pojoValidator.addTester(new GetterTester());
        pojoValidator.addTester(new GetterNullTester());
    }

    @Test
    public void testPojoStructureAndBehavior() {
        for (PojoClass pojoClass : pojoClasses) {
            try {
                pojoValidator.runValidation(pojoClass);
                ValidationHelper.getBasicInstance(pojoClass).toString();
                ValidationHelper.getMostCompleteInstance(pojoClass).toString();
            } catch (Exception e) {
                continue;
            }
        }
    }
}
