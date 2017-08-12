/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.properties;

import java.util.Map;

import org.junit.Test;

import net.sourceforge.pmd.PropertyDescriptorField;

/**
 * @author Clément Fournier
 */
public abstract class AbstractPackagedPropertyDescriptorTester<T> extends AbstractPropertyDescriptorTester<T> {

    /* default */ AbstractPackagedPropertyDescriptorTester(String typeName) {
        super(typeName);
    }


    @Test
    public void testMissingPackageNames() {
        Map<PropertyDescriptorField, String> attributes = getPropertyDescriptorValues();
        attributes.remove(PropertyDescriptorField.LEGAL_PACKAGES);
        getMultiFactory().createWith(attributes); // no exception, null is ok
        getSingleFactory().createWith(attributes);
    }


    @Override
    protected Map<PropertyDescriptorField, String> getPropertyDescriptorValues() {
        Map<PropertyDescriptorField, String> attributes = super.getPropertyDescriptorValues();
        attributes.put(PropertyDescriptorField.LEGAL_PACKAGES, "java.lang");
        return attributes;
    }
}
