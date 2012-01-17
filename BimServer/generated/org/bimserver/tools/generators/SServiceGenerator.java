package org.bimserver.tools.generators;

import org.eclipse.emf.ecore.*;
import org.bimserver.utils.*;
import java.io.File;

public class SServiceGenerator
{
  protected static String nl;
  public static synchronized SServiceGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    SServiceGenerator result = new SServiceGenerator();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package org.bimserver.interfaces;" + NL;
  protected final String TEXT_2 = NL + NL + "import org.bimserver.shared.meta.*;" + NL;
  protected final String TEXT_3 = NL;
  protected final String TEXT_4 = NL;
  protected final String TEXT_5 = NL + NL + "public class S";
  protected final String TEXT_6 = "Service extends SService {" + NL + "" + NL + "\tpublic S";
  protected final String TEXT_7 = "Service(Class<?> cl) {" + NL + "\t\tsuper(cl);" + NL + "\t}" + NL + "\t" + NL + "\t\tpublic void init() {" + NL + "\t\t\ttry {";
  protected final String TEXT_8 = NL + "\t\taddType(new SClass(this, Class.forName(\"org.bimserver.interfaces.objects.S";
  protected final String TEXT_9 = "\")));";
  protected final String TEXT_10 = NL + "\t\t} catch (ClassNotFoundException e) {" + NL + "\t\t\te.printStackTrace();" + NL + "\t\t}" + NL + "\t}" + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
/******************************************************************************
 * Copyright (C) 2011  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

    stringBuffer.append(TEXT_2);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(Licenser.getCommentedLicenseText(new File("license.txt")));
    stringBuffer.append(TEXT_4);
    
Object[] args = (Object[])argument;
Class<?> cl = (Class<?>)args[0];
EPackage ePackage = (EPackage)args[1];

    stringBuffer.append(TEXT_5);
    stringBuffer.append(cl.getSimpleName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cl.getSimpleName());
    stringBuffer.append(TEXT_7);
    
		for (EClassifier eClassifier : ePackage.getEClassifiers()) {
			if (eClassifier instanceof EClass || eClassifier instanceof EEnum) {

    stringBuffer.append(TEXT_8);
    stringBuffer.append(eClassifier.getName());
    stringBuffer.append(TEXT_9);
    
			}
		}

    stringBuffer.append(TEXT_10);
    return stringBuffer.toString();
  }
}