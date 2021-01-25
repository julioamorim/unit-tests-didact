package io.github.julioamorim.servicos;

import io.github.julioamorim.wcaquino.entidades.Usuario;
import org.junit.Assert;
import org.junit.Test;

public class AssertTest {

    @Test
    public void test() {

        Assert.assertTrue(true);
        Assert.assertFalse(false);
        Assert.assertEquals(1, 1);

        //assert with double values, third parameter is a delta offset of comparator
        Assert.assertEquals(0.51234, 0.512, 0.001);
        Assert.assertEquals(Math.PI, 3.14, 0.01);

        int i = 5;
        Integer i2 = 5;

        Assert.assertEquals("Erro de comapração", Integer.valueOf(i), i2);
        Assert.assertEquals(i, i2.intValue());
        Assert.assertEquals("car", "car");
        Assert.assertTrue("car".equalsIgnoreCase("Car"));
        Assert.assertTrue("car".startsWith("c"));

        Usuario usuario1 = new Usuario("usuario1");
        Usuario usuario2 = new Usuario("usuario1");
        Usuario usuario3 = null;
        Assert.assertEquals(usuario1, usuario2);
        //to vetify if the object is same instance
        Assert.assertSame(usuario2, usuario2);
        Assert.assertNull(usuario3);
        Assert.assertNotNull(usuario1);


    }


}
