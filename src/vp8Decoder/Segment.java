/*	This file is part of javavp8decoder.

    javavp8decoder is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    javavp8decoder is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with javavp8decoder.  If not, see <http://www.gnu.org/licenses/>.
*/
package vp8Decoder;

public class Segment {
	int P0, P1, P2, P3;
	int Q0, Q1, Q2, Q3;
	
	public String toString() {
		return ""+P3+" "+P2+" "+P1+" "+P0+" "+Q0+" "+Q1+" "+Q2+" "+Q3;
	}
}
