/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mongolianstring2tree.utils;

import java.util.UUID;

/**
 *
 * @author yangy
 */
public class IDTool {

    public static String newGUID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replace("-", "");
    }
}
