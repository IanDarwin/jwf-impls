//The Salmon Open Framework for Internet Applications (SOFIA)
//Copyright (C) 1999 - 2002, Salmon LLC
//
//This program is free software; you can redistribute it and/or
//modify it under the terms of the GNU General Public License version 2
//as published by the Free Software Foundation;
//
//This program is distributed in the hope that it will be useful,
//but WITHOUT ANY WARRANTY; without even the implied warranty of
//MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//GNU General Public License for more details.
//
//You should have received a copy of the GNU General Public License
//along with this program; if not, write to the Free Software
//Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
//
//For more information please visit http://www.salmonllc.com

package sofiademo;

import com.salmonllc.sql.DataStoreExpression;
import com.salmonllc.sql.DataStoreBuffer;
import com.salmonllc.sql.DataStoreException;

/**
 * An object that does simple phone number validation and transformation. It can be attached to an HtmlValidator Text or DataStore validation rule
 */
public class PhoneValidation implements java.io.Serializable, DataStoreExpression {
    private String _colName;
    private boolean _required;

    public PhoneValidation(String colName, boolean required) {
        _required = required;
        _colName = colName;
    }

    public Object evaluateExpression(DataStoreBuffer dsBuf, int row) throws DataStoreException {
        String phone = dsBuf.getString(row, _colName);
        if (phone == null)
            phone = "";
        else
            phone = phone.trim();
        if (phone.length() == 0) {
            if (_required)
                return Boolean.FALSE;
            else
                return Boolean.TRUE;
        }

        StringBuffer dig = new StringBuffer(phone.length());
        for (int i = 0; i < phone.length();i++) {
            char c = phone.charAt(i);
            if (Character.isDigit(c))
                dig.append(c);
        }

        if (dig.length() >= 10) {
            String newPhone = "(" + dig.substring(0,3) + ") " + dig.substring(3,6) + "-" + dig.substring(6,10);
            if (dig.length() > 10)
                newPhone += " ex:" + dig.substring(10);
            if (!newPhone.equals(phone))
                dsBuf.setString(row,_colName,newPhone);
            return Boolean.TRUE;
        }

        return Boolean.FALSE;

    }

}
