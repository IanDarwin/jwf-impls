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
 * An object that does simple email address validation. It can be attached to an HtmlValidator Text or DataStore validation rule
 */
public class EMailValidation implements java.io.Serializable, DataStoreExpression {
    private String _colName;

    public EMailValidation(String colName) {
        _colName = colName;
    }

    public Object evaluateExpression(DataStoreBuffer dsBuf, int row) throws DataStoreException {
        String address = dsBuf.getString(row, _colName);
        if (address != null)
            if (address.indexOf('@') == -1 || address.startsWith("@") || address.endsWith("@"))
                return Boolean.FALSE;
        return Boolean.TRUE;
    }

}
