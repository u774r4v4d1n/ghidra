/* ###
 * IP: GHIDRA
 * REVIEWED: YES
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ghidra.app.plugin.core.symtable;

import ghidra.framework.plugintool.ServiceProvider;
import ghidra.program.model.address.Address;
import ghidra.program.model.listing.Program;
import ghidra.program.model.symbol.Symbol;
import ghidra.program.model.symbol.SymbolTable;
import ghidra.util.table.ProgramLocationTableRowMapper;

public class SymbolRowObjectToAddressTableRowMapper extends
		ProgramLocationTableRowMapper<SymbolRowObject, Address> {

	@Override
	public Address map(SymbolRowObject rowObject, Program data, ServiceProvider serviceProvider) {
		SymbolTable symbolTable = data.getSymbolTable();
		Symbol symbol = symbolTable.getSymbol(rowObject.getKey());
		if (symbol == null) {
			return null;
		}

		return symbol.getAddress();
	}

}