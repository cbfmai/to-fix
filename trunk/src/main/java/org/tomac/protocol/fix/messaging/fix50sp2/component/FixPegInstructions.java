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


import org.tomac.protocol.fix.messaging.fix50sp2.FixTags;
import org.tomac.protocol.fix.messaging.fix50sp2.FixMessageInfo.*;

public class FixPegInstructions implements FixComponent
{

	public long pegOffsetValue = 0;
	public long pegPriceType = 0;
	public long pegMoveType = 0;
	public long pegOffsetType = 0;
	public long pegLimitType = 0;
	public long pegRoundDirection = 0;
	public long pegScope = 0;
	public byte[] pegSecurityIDSource;
	public byte[] pegSecurityID;
	public byte[] pegSymbol;
	public byte[] pegSecurityDesc;

	public FixPegInstructions() {
		super();

		pegSecurityIDSource = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		pegSecurityID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		pegSymbol = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		pegSecurityDesc = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		pegOffsetValue = Long.MAX_VALUE;		
		pegPriceType = Long.MAX_VALUE;		
		pegMoveType = Long.MAX_VALUE;		
		pegOffsetType = Long.MAX_VALUE;		
		pegLimitType = Long.MAX_VALUE;		
		pegRoundDirection = Long.MAX_VALUE;		
		pegScope = Long.MAX_VALUE;		
		Utils.fill( pegSecurityIDSource, (byte)0 );
		Utils.fill( pegSecurityID, (byte)0 );
		Utils.fill( pegSymbol, (byte)0 );
		Utils.fill( pegSecurityDesc, (byte)0 );
	}

	public void getAll(int id, ByteBuffer buf) throws FixSessionException, FixGarbledException
	{

		int startTagPosition = buf.position();

		int lastTagPosition = buf.position();
		do {
			ByteBuffer value;

			value = buf;

			switch( id ) {

			case FixTags.PEGOFFSETVALUE_INT:
				pegOffsetValue = FixUtils.getTagFloatValue(null ,id ,value);
				break;

			case FixTags.PEGPRICETYPE_INT:
				pegPriceType = FixUtils.getTagIntValue(null ,id ,value );
				if (!PegPriceType.isValid(pegPriceType) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + pegPriceType + ") for tag").getBytes(), id, new byte[0] );
				break;

			case FixTags.PEGMOVETYPE_INT:
				pegMoveType = FixUtils.getTagIntValue(null ,id ,value );
				if (!PegMoveType.isValid(pegMoveType) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + pegMoveType + ") for tag").getBytes(), id, new byte[0] );
				break;

			case FixTags.PEGOFFSETTYPE_INT:
				pegOffsetType = FixUtils.getTagIntValue(null ,id ,value );
				if (!PegOffsetType.isValid(pegOffsetType) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + pegOffsetType + ") for tag").getBytes(), id, new byte[0] );
				break;

			case FixTags.PEGLIMITTYPE_INT:
				pegLimitType = FixUtils.getTagIntValue(null ,id ,value );
				if (!PegLimitType.isValid(pegLimitType) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + pegLimitType + ") for tag").getBytes(), id, new byte[0] );
				break;

			case FixTags.PEGROUNDDIRECTION_INT:
				pegRoundDirection = FixUtils.getTagIntValue(null ,id ,value );
				if (!PegRoundDirection.isValid(pegRoundDirection) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + pegRoundDirection + ") for tag").getBytes(), id, new byte[0] );
				break;

			case FixTags.PEGSCOPE_INT:
				pegScope = FixUtils.getTagIntValue(null ,id ,value );
				if (!PegScope.isValid(pegScope) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + pegScope + ") for tag").getBytes(), id, new byte[0] );
				break;

			case FixTags.PEGSECURITYIDSOURCE_INT:
				pegSecurityIDSource = FixUtils.getTagStringValue(null ,id ,value, pegSecurityIDSource);
				break;

			case FixTags.PEGSECURITYID_INT:
				pegSecurityID = FixUtils.getTagStringValue(null ,id ,value, pegSecurityID);
				break;

			case FixTags.PEGSYMBOL_INT:
				pegSymbol = FixUtils.getTagStringValue(null ,id ,value, pegSymbol);
				break;

			case FixTags.PEGSECURITYDESC_INT:
				pegSecurityDesc = FixUtils.getTagStringValue(null ,id ,value, pegSecurityDesc);
				break;

			// we will always endup with unknown tag, unread and return to upper layer in hierarchy
			default:
				id = checkRequiredTags();
				if (id > 0) throw new FixSessionException(SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing".getBytes(), id, new byte[0] );

				buf.position( lastTagPosition );
				return;

			}

			lastTagPosition = buf.position();

		} while ( ( id = FixUtils.getTagId( buf ) ) >= 0 );

		buf.position(startTagPosition);

	}

	private int checkRequiredTags() {
		int tag = -1;

		return tag;

	}
	@Override
	public boolean isSet()
	{
		if (FixUtils.isSet(pegOffsetValue)) return true;
		if (FixUtils.isSet(pegPriceType)) return true;
		if (FixUtils.isSet(pegMoveType)) return true;
		if (FixUtils.isSet(pegOffsetType)) return true;
		if (FixUtils.isSet(pegLimitType)) return true;
		if (FixUtils.isSet(pegRoundDirection)) return true;
		if (FixUtils.isSet(pegScope)) return true;
		if (FixUtils.isSet(pegSecurityIDSource)) return true;
		if (FixUtils.isSet(pegSecurityID)) return true;
		if (FixUtils.isSet(pegSymbol)) return true;
		if (FixUtils.isSet(pegSecurityDesc)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(pegOffsetValue)) FixUtils.putFixFloatTag( out, FixTags.PEGOFFSETVALUE_INT, pegOffsetValue);
		if (FixUtils.isSet(pegPriceType)) FixUtils.putFixTag( out, FixTags.PEGPRICETYPE_INT, pegPriceType);
		if (FixUtils.isSet(pegMoveType)) FixUtils.putFixTag( out, FixTags.PEGMOVETYPE_INT, pegMoveType);
		if (FixUtils.isSet(pegOffsetType)) FixUtils.putFixTag( out, FixTags.PEGOFFSETTYPE_INT, pegOffsetType);
		if (FixUtils.isSet(pegLimitType)) FixUtils.putFixTag( out, FixTags.PEGLIMITTYPE_INT, pegLimitType);
		if (FixUtils.isSet(pegRoundDirection)) FixUtils.putFixTag( out, FixTags.PEGROUNDDIRECTION_INT, pegRoundDirection);
		if (FixUtils.isSet(pegScope)) FixUtils.putFixTag( out, FixTags.PEGSCOPE_INT, pegScope);
		if (FixUtils.isSet(pegSecurityIDSource)) FixUtils.putFixTag( out, FixTags.PEGSECURITYIDSOURCE_INT, pegSecurityIDSource, 0, Utils.lastIndexTrim(pegSecurityIDSource, (byte)0) );
		if (FixUtils.isSet(pegSecurityID)) FixUtils.putFixTag( out, FixTags.PEGSECURITYID_INT, pegSecurityID, 0, Utils.lastIndexTrim(pegSecurityID, (byte)0) );
		if (FixUtils.isSet(pegSymbol)) FixUtils.putFixTag( out, FixTags.PEGSYMBOL_INT, pegSymbol, 0, Utils.lastIndexTrim(pegSymbol, (byte)0) );
		if (FixUtils.isSet(pegSecurityDesc)) FixUtils.putFixTag( out, FixTags.PEGSECURITYDESC_INT, pegSecurityDesc, 0, Utils.lastIndexTrim(pegSecurityDesc, (byte)0) );
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

			if (FixUtils.isSet(pegOffsetValue)) s += "PegOffsetValue(211)=" + String.valueOf(pegOffsetValue) + sep;
			if (FixUtils.isSet(pegPriceType)) s += "PegPriceType(1094)=" + String.valueOf(pegPriceType) + sep;
			if (FixUtils.isSet(pegMoveType)) s += "PegMoveType(835)=" + String.valueOf(pegMoveType) + sep;
			if (FixUtils.isSet(pegOffsetType)) s += "PegOffsetType(836)=" + String.valueOf(pegOffsetType) + sep;
			if (FixUtils.isSet(pegLimitType)) s += "PegLimitType(837)=" + String.valueOf(pegLimitType) + sep;
			if (FixUtils.isSet(pegRoundDirection)) s += "PegRoundDirection(838)=" + String.valueOf(pegRoundDirection) + sep;
			if (FixUtils.isSet(pegScope)) s += "PegScope(840)=" + String.valueOf(pegScope) + sep;
			if (FixUtils.isSet(pegSecurityIDSource)) s += "PegSecurityIDSource(1096)=" + new String(pegSecurityIDSource) + sep;
			if (FixUtils.isSet(pegSecurityID)) s += "PegSecurityID(1097)=" + new String(pegSecurityID) + sep;
			if (FixUtils.isSet(pegSymbol)) s += "PegSymbol(1098)=" + new String(pegSymbol) + sep;
			if (FixUtils.isSet(pegSecurityDesc)) s += "PegSecurityDesc(1099)=" + new String(pegSecurityDesc) + sep;
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixPegInstructions)) return false;

			FixPegInstructions msg = (FixPegInstructions) o;

		if (!( pegOffsetValue==msg.pegOffsetValue)) return false;

		if (!( pegPriceType==msg.pegPriceType)) return false;

		if (!( pegMoveType==msg.pegMoveType)) return false;

		if (!( pegOffsetType==msg.pegOffsetType)) return false;

		if (!( pegLimitType==msg.pegLimitType)) return false;

		if (!( pegRoundDirection==msg.pegRoundDirection)) return false;

		if (!( pegScope==msg.pegScope)) return false;

		if (!Utils.equals( pegSecurityIDSource, msg.pegSecurityIDSource)) return false;

		if (!Utils.equals( pegSecurityID, msg.pegSecurityID)) return false;

		if (!Utils.equals( pegSymbol, msg.pegSymbol)) return false;

		if (!Utils.equals( pegSecurityDesc, msg.pegSecurityDesc)) return false;

		return true;
	}
}