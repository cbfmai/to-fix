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

public class FixStipulations
{

	public int noStipulations;
	public Stipulations[] group;

	public void getAll(int noStipulations, ByteBuffer buf) throws FixSessionException, FixGarbledException {
		this.noStipulations = noStipulations;

		if (noStipulations < 1) throw new FixSessionException(SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, ("Incorrect num in group count " + noStipulations ).getBytes(), FixTags.NOSTIPULATIONS_INT, new byte[0]);
		// this will leak memory if we grow the group
		if (group == null || group.length < noStipulations) {
			group = new Stipulations[noStipulations];

			for ( int i = 0; i < noStipulations; i++ ) group[i] = new Stipulations();
	}

		for ( int i = 0; i < noStipulations; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noStipulations; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noStipulations; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noStipulations; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixStipulations)) return false;

		FixStipulations msg = (FixStipulations) o;

		for (int i = 0; i<noStipulations; i++)
			if (!group[i].equals(msg.group[i])) return false;
		return true;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noStipulations; i++)
			s += group[i].toString();
		return s;
	}

public class Stipulations implements FixComponent
{

	public byte[] stipulationType;
	public byte[] stipulationValue;

	public Stipulations() {
		super();

		stipulationType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		stipulationValue = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		Utils.fill( stipulationType, (byte)0 );
		Utils.fill( stipulationValue, (byte)0 );
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException, FixGarbledException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.STIPULATIONTYPE_INT) {
				stipulationType = FixUtils.getTagStringValue(null ,id ,value, stipulationType);
				if (!FixMessageInfo.StipulationType.isValid(stipulationType) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + stipulationType + ") for tag").getBytes(), id, new byte[0] );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.STIPULATIONVALUE_INT) {
				stipulationValue = FixUtils.getTagStringValue(null ,id ,value, stipulationValue);
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
		if (FixUtils.isSet(stipulationType)) return true;
		if (FixUtils.isSet(stipulationValue)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(stipulationType)) FixUtils.putFixTag( out, FixTags.STIPULATIONTYPE_INT, stipulationType, 0, Utils.lastIndexTrim(stipulationType, (byte)0) );
		if (FixUtils.isSet(stipulationValue)) FixUtils.putFixTag( out, FixTags.STIPULATIONVALUE_INT, stipulationValue, 0, Utils.lastIndexTrim(stipulationValue, (byte)0) );
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

			if (FixUtils.isSet(stipulationType)) s += "StipulationType(233)=" + new String(stipulationType) + sep;
			if (FixUtils.isSet(stipulationValue)) s += "StipulationValue(234)=" + new String(stipulationValue) + sep;
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof Stipulations)) return false;

			Stipulations msg = (Stipulations) o;

		if (!Utils.equals( stipulationType, msg.stipulationType)) return false;

		if (!Utils.equals( stipulationValue, msg.stipulationValue)) return false;

		return true;
	}
}
}