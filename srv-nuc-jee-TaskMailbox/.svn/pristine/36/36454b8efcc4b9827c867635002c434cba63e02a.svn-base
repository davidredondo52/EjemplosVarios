package com.telefonica.cana.srv.nuc.taskmailbox.msg;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.PojoValidator;
import com.openpojo.validation.rule.impl.NoNestedClassRule;
import com.openpojo.validation.rule.impl.NoPublicFieldsExceptStaticFinalRule;
import com.openpojo.validation.rule.impl.NoPublicFieldsRule;
import com.openpojo.validation.rule.impl.NoStaticExceptFinalRule;
import com.openpojo.validation.rule.impl.SerializableMustHaveSerialVersionUIDRule;
import com.openpojo.validation.test.impl.DefaultValuesNullTester;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;
import com.openpojo.validation.utils.ValidationHelper;
import com.telefonica.coco.lib.test.openpojo.AdderTester;
import com.telefonica.coco.lib.test.openpojo.ArrayTester;
import com.telefonica.coco.lib.test.openpojo.HashCodeAndEqualsTester;
import com.telefonica.coco.lib.test.openpojo.RemoverTester;
import com.telefonica.coco.lib.test.openpojo.filters.DefaultPojoFilter;

public class PojoTest {

    private PojoValidator pojoValidator;
    private List<PojoClass> pojoClasses;

    @Before
    public void setup() {

        pojoValidator = new PojoValidator();
        pojoClasses = PojoClassFactory.getPojoClassesRecursively("com.telefonica.cana.srv.nuc.taskmailbox.msg",
                new DefaultPojoFilter());

        NullArrayTester.propareAbstractPojoClasses(pojoClasses);

        // Create Rules to validate structure for POJO_PACKAGE
        pojoValidator.addRule(new NoPublicFieldsRule());
        pojoValidator.addRule(new NoStaticExceptFinalRule());
        pojoValidator.addRule(new NoNestedClassRule());
        pojoValidator.addRule(new NoPublicFieldsExceptStaticFinalRule());
        pojoValidator.addRule(new SerializableMustHaveSerialVersionUIDRule());

        pojoValidator.addTester(new NullArrayTester());

        // Create Testers to validate behaviour for POJO_PACKAGE
        pojoValidator.addTester(new DefaultValuesNullTester());
        pojoValidator.addTester(new SetterTester());
        pojoValidator.addTester(new GetterTester());
        pojoValidator.addTester(new AdderTester());
        pojoValidator.addTester(new RemoverTester());
        pojoValidator.addTester(new HashCodeAndEqualsTester());
        pojoValidator.addTester(new ArrayTester());
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
