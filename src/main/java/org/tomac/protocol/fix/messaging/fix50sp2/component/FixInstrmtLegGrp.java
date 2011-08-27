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


import org.tomac.protocol.fix.messaging.fix50sp2.FixMessageInfo.SessionRejectReason;
import org.tomac.protocol.fix.messaging.fix50sp2.FixMessageInfo;
import org.tomac.protocol.fix.messaging.fix50sp2.FixTags;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixInstrumentLeg;

public class FixInstrmtLegGrp
{

	public int noLegs;
	public InstrmtLegGrp[] group;

	public void getAll(int noLegs, ByteBuffer buf) throws FixSessionException, FixGarbledException {
		this.noLegs = noLegs;

		if (noLegs < 1) throw new FixSessionException(SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, ("Incorrect num in group count " + noLegs ).getBytes(), FixTags.NOLEGS_INT, new byte[0]);
		// this will leak memory if we grow the group
		if (group == null || group.length < noLegs) {
			group = new InstrmtLegGrp[noLegs];

			for ( int i = 0; i < noLegs; i++ ) group[i] = new InstrmtLegGrp();
	}

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
	public boolean equals(Object o) {
		if (! ( o instanceof FixInstrmtLegGrp)) return false;

		FixInstrmtLegGrp msg = (FixInstrmtLegGrp) o;

		for (int i = 0; i<noLegs; i++)
			if (!group[i].equals(msg.group[i])) return false;
		return true;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noLegs; i++)
			s += group[i].toString();
		return s;
	}

public class InstrmtLegGrp implements FixComponent
{

	public FixInstrumentLeg instrumentLeg;

	public InstrmtLegGrp() {
		super();

		instrumentLeg = new FixInstrumentLeg();
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		instrumentLeg.clear();
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException, FixGarbledException
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

			id = checkRequiredTags();
				if (id > 0) throw new FixSessionException(SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing".getBytes(), id, new byte[0] );

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
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(instrumentLeg.legSymbol)) instrumentLeg.encode( out );
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
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof InstrmtLegGrp)) return false;

			InstrmtLegGrp msg = (InstrmtLegGrp) o;

		if (!instrumentLeg.equals(msg.instrumentLeg)) return false;

		return true;
	}
}
}
