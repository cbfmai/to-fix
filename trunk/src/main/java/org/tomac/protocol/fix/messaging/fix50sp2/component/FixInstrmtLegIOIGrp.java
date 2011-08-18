package org.tomac.protocol.fix.messaging.fix50sp2.component;

// DO NOT EDIT!!!
// This file is generated by FixMessageGenerator.
// If you need additional functionality, put it in a helper class
// that does not live in this folder!!!  Any java file in this folder 
// will be deleted upon the next run of the FixMessageGenerator!

import java.nio.ByteBuffer;

import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.FixSessionException;
import org.tomac.protocol.fix.FixGarbledException;
import org.tomac.utils.Utils;
import org.tomac.protocol.fix.FixConstants;


import org.tomac.protocol.fix.messaging.fix50sp2.FixMessageInfo.*;
import org.tomac.protocol.fix.messaging.fix50sp2.FixTags;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixInstrumentLeg;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixLegStipulations;

public class FixInstrmtLegIOIGrp
{

	public int noLegs;
	public InstrmtLegIOIGrp[] group;

	public void getAll(int noLegs, ByteBuffer buf) throws FixSessionException {
		this.noLegs = noLegs;

		if (noLegs < 1) throw new FixSessionException("asdasd");
		// this will leak memory if we grow the group
		if (group.length < noLegs) 
			group = new InstrmtLegIOIGrp[noLegs];

		for ( int i = 0; i < noLegs; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noLegs; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noLegs; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noLegs; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noLegs; i++)
			s += group[i].toString();
		return s;
	}

public class InstrmtLegIOIGrp implements FixComponent
{

	public FixInstrumentLeg instrumentLeg;
	public byte[] legIOIQty;
	public FixLegStipulations legStipulations;

	public InstrmtLegIOIGrp() {
		super();

		instrumentLeg = new FixInstrumentLeg();
		legIOIQty = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		legStipulations = new FixLegStipulations();
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		Utils.fill( legIOIQty, (byte)0 );
		instrumentLeg.clear();
		legStipulations.clear();
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.LEGSYMBOL_INT) {
				instrumentLeg.getAll(FixTags.LEGSYMBOL_INT, buf);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.LEGIOIQTY_INT) {
				legIOIQty = FixUtils.getTagStringValue(value, legIOIQty);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.NOLEGSTIPULATIONS_INT) {
				legStipulations.getAll(FixTags.NOLEGSTIPULATIONS_INT, buf);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			id = checkRequiredTags();
			if (id > 0) throw new FixSessionException(buf, "Required tag missing: " + id );

			buf.position( lastTagPosition );
			return;

	}

	private int checkRequiredTags() {
		int tag = -1;

		return tag;

	}
	@Override
	public boolean isSet()
	{
		if (FixUtils.isSet(instrumentLeg.legSymbol)) return true;
		if (FixUtils.isSet(legIOIQty)) return true;
		if (FixUtils.isSet(legStipulations.noLegStipulations)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(instrumentLeg.legSymbol)) instrumentLeg.encode( out );
		if (FixUtils.isSet(legIOIQty)) FixUtils.putFixTag( out, FixTags.LEGIOIQTY_INT, legIOIQty, 0, Utils.lastIndexTrim(legIOIQty, (byte)0) );
		if (FixUtils.isSet(legStipulations.noLegStipulations)) legStipulations.encode( out );
	}
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will end up in nifelheim!
	**/
	@Override
	public String toString() {
		char sep = '\n';
		if (Boolean.getBoolean("fix.useOneLiner")) sep = ( byte )0x01;

		String s = "";

			if (FixUtils.isSet(instrumentLeg.legSymbol)) s += instrumentLeg.toString();
			if (FixUtils.isSet(legIOIQty)) s += "LegIOIQty(682)=" + new String(legIOIQty) + sep;
			if (FixUtils.isSet(legStipulations.noLegStipulations)) s += legStipulations.toString();
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof InstrmtLegIOIGrp)) return false;

			InstrmtLegIOIGrp msg = (InstrmtLegIOIGrp) o;

		if ( ! super.equals(msg) ) return false;

		if (!instrumentLeg.equals(msg.instrumentLeg)) return false;

		if (!Utils.equals( legIOIQty, msg.legIOIQty)) return false;

		if (!legStipulations.equals(msg.legStipulations)) return false;

		return true;
	}
}
}
