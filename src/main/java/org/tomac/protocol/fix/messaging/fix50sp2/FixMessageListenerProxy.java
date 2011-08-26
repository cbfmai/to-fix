package org.tomac.protocol.fix.messaging.fix50sp2;

// DO NOT EDIT!!!
// This file is generated by FixMessageGenerator.
// If you need additional functionality, put it in a helper class
// that does not live in this folder!!!  Any java file in this folder 
// will be deleted upon the next run of the FixMessageGenerator!

import java.nio.ByteBuffer;
public class FixMessageListenerProxy implements FixMessageListener
{

	FixMessageListener sessionLayer;
	FixMessageListener applicationLayer;

	public FixMessageListenerProxy(FixMessageListener l1, FixMessageListener l2) {
		this.sessionLayer = l1;
		this.applicationLayer = l2;
	}

	@Override
	public void onUnknownMessageType(FixMessage msg) {
		sessionLayer.onUnknownMessageType(msg);
		applicationLayer.onUnknownMessageType(msg);
	}

	@Override
	public void onFixHeartbeat( FixHeartbeat msg ) {
		sessionLayer.onFixHeartbeat( msg );
		applicationLayer.onFixHeartbeat( msg );
	}

	@Override
	public void onFixTestRequest( FixTestRequest msg ) {
		sessionLayer.onFixTestRequest( msg );
		applicationLayer.onFixTestRequest( msg );
	}

	@Override
	public void onFixResendRequest( FixResendRequest msg ) {
		sessionLayer.onFixResendRequest( msg );
		applicationLayer.onFixResendRequest( msg );
	}

	@Override
	public void onFixReject( FixReject msg ) {
		sessionLayer.onFixReject( msg );
		applicationLayer.onFixReject( msg );
	}

	@Override
	public void onFixSequenceReset( FixSequenceReset msg ) {
		sessionLayer.onFixSequenceReset( msg );
		applicationLayer.onFixSequenceReset( msg );
	}

	@Override
	public void onFixLogout( FixLogout msg ) {
		sessionLayer.onFixLogout( msg );
		applicationLayer.onFixLogout( msg );
	}

	@Override
	public void onFixIOI( FixIOI msg ) {
		sessionLayer.onFixIOI( msg );
		applicationLayer.onFixIOI( msg );
	}

	@Override
	public void onFixAdvertisement( FixAdvertisement msg ) {
		sessionLayer.onFixAdvertisement( msg );
		applicationLayer.onFixAdvertisement( msg );
	}

	@Override
	public void onFixExecutionReport( FixExecutionReport msg ) {
		sessionLayer.onFixExecutionReport( msg );
		applicationLayer.onFixExecutionReport( msg );
	}

	@Override
	public void onFixOrderCancelReject( FixOrderCancelReject msg ) {
		sessionLayer.onFixOrderCancelReject( msg );
		applicationLayer.onFixOrderCancelReject( msg );
	}

	@Override
	public void onFixLogon( FixLogon msg ) {
		sessionLayer.onFixLogon( msg );
		applicationLayer.onFixLogon( msg );
	}

	@Override
	public void onFixNews( FixNews msg ) {
		sessionLayer.onFixNews( msg );
		applicationLayer.onFixNews( msg );
	}

	@Override
	public void onFixEmail( FixEmail msg ) {
		sessionLayer.onFixEmail( msg );
		applicationLayer.onFixEmail( msg );
	}

	@Override
	public void onFixNewOrderSingle( FixNewOrderSingle msg ) {
		sessionLayer.onFixNewOrderSingle( msg );
		applicationLayer.onFixNewOrderSingle( msg );
	}

	@Override
	public void onFixNewOrderList( FixNewOrderList msg ) {
		sessionLayer.onFixNewOrderList( msg );
		applicationLayer.onFixNewOrderList( msg );
	}

	@Override
	public void onFixOrderCancelRequest( FixOrderCancelRequest msg ) {
		sessionLayer.onFixOrderCancelRequest( msg );
		applicationLayer.onFixOrderCancelRequest( msg );
	}

	@Override
	public void onFixOrderCancelReplaceRequest( FixOrderCancelReplaceRequest msg ) {
		sessionLayer.onFixOrderCancelReplaceRequest( msg );
		applicationLayer.onFixOrderCancelReplaceRequest( msg );
	}

	@Override
	public void onFixOrderStatusRequest( FixOrderStatusRequest msg ) {
		sessionLayer.onFixOrderStatusRequest( msg );
		applicationLayer.onFixOrderStatusRequest( msg );
	}

	@Override
	public void onFixAllocationInstruction( FixAllocationInstruction msg ) {
		sessionLayer.onFixAllocationInstruction( msg );
		applicationLayer.onFixAllocationInstruction( msg );
	}

	@Override
	public void onFixListCancelRequest( FixListCancelRequest msg ) {
		sessionLayer.onFixListCancelRequest( msg );
		applicationLayer.onFixListCancelRequest( msg );
	}

	@Override
	public void onFixListExecute( FixListExecute msg ) {
		sessionLayer.onFixListExecute( msg );
		applicationLayer.onFixListExecute( msg );
	}

	@Override
	public void onFixListStatusRequest( FixListStatusRequest msg ) {
		sessionLayer.onFixListStatusRequest( msg );
		applicationLayer.onFixListStatusRequest( msg );
	}

	@Override
	public void onFixListStatus( FixListStatus msg ) {
		sessionLayer.onFixListStatus( msg );
		applicationLayer.onFixListStatus( msg );
	}

	@Override
	public void onFixAllocationInstructionAck( FixAllocationInstructionAck msg ) {
		sessionLayer.onFixAllocationInstructionAck( msg );
		applicationLayer.onFixAllocationInstructionAck( msg );
	}

	@Override
	public void onFixDontKnowTradeDK( FixDontKnowTradeDK msg ) {
		sessionLayer.onFixDontKnowTradeDK( msg );
		applicationLayer.onFixDontKnowTradeDK( msg );
	}

	@Override
	public void onFixQuoteRequest( FixQuoteRequest msg ) {
		sessionLayer.onFixQuoteRequest( msg );
		applicationLayer.onFixQuoteRequest( msg );
	}

	@Override
	public void onFixQuote( FixQuote msg ) {
		sessionLayer.onFixQuote( msg );
		applicationLayer.onFixQuote( msg );
	}

	@Override
	public void onFixSettlementInstructions( FixSettlementInstructions msg ) {
		sessionLayer.onFixSettlementInstructions( msg );
		applicationLayer.onFixSettlementInstructions( msg );
	}

	@Override
	public void onFixMarketDataRequest( FixMarketDataRequest msg ) {
		sessionLayer.onFixMarketDataRequest( msg );
		applicationLayer.onFixMarketDataRequest( msg );
	}

	@Override
	public void onFixMarketDataSnapshotFullRefresh( FixMarketDataSnapshotFullRefresh msg ) {
		sessionLayer.onFixMarketDataSnapshotFullRefresh( msg );
		applicationLayer.onFixMarketDataSnapshotFullRefresh( msg );
	}

	@Override
	public void onFixMarketDataIncrementalRefresh( FixMarketDataIncrementalRefresh msg ) {
		sessionLayer.onFixMarketDataIncrementalRefresh( msg );
		applicationLayer.onFixMarketDataIncrementalRefresh( msg );
	}

	@Override
	public void onFixMarketDataRequestReject( FixMarketDataRequestReject msg ) {
		sessionLayer.onFixMarketDataRequestReject( msg );
		applicationLayer.onFixMarketDataRequestReject( msg );
	}

	@Override
	public void onFixQuoteCancel( FixQuoteCancel msg ) {
		sessionLayer.onFixQuoteCancel( msg );
		applicationLayer.onFixQuoteCancel( msg );
	}

	@Override
	public void onFixQuoteStatusRequest( FixQuoteStatusRequest msg ) {
		sessionLayer.onFixQuoteStatusRequest( msg );
		applicationLayer.onFixQuoteStatusRequest( msg );
	}

	@Override
	public void onFixMassQuoteAcknowledgement( FixMassQuoteAcknowledgement msg ) {
		sessionLayer.onFixMassQuoteAcknowledgement( msg );
		applicationLayer.onFixMassQuoteAcknowledgement( msg );
	}

	@Override
	public void onFixSecurityDefinitionRequest( FixSecurityDefinitionRequest msg ) {
		sessionLayer.onFixSecurityDefinitionRequest( msg );
		applicationLayer.onFixSecurityDefinitionRequest( msg );
	}

	@Override
	public void onFixSecurityDefinition( FixSecurityDefinition msg ) {
		sessionLayer.onFixSecurityDefinition( msg );
		applicationLayer.onFixSecurityDefinition( msg );
	}

	@Override
	public void onFixSecurityStatusRequest( FixSecurityStatusRequest msg ) {
		sessionLayer.onFixSecurityStatusRequest( msg );
		applicationLayer.onFixSecurityStatusRequest( msg );
	}

	@Override
	public void onFixSecurityStatus( FixSecurityStatus msg ) {
		sessionLayer.onFixSecurityStatus( msg );
		applicationLayer.onFixSecurityStatus( msg );
	}

	@Override
	public void onFixTradingSessionStatusRequest( FixTradingSessionStatusRequest msg ) {
		sessionLayer.onFixTradingSessionStatusRequest( msg );
		applicationLayer.onFixTradingSessionStatusRequest( msg );
	}

	@Override
	public void onFixTradingSessionStatus( FixTradingSessionStatus msg ) {
		sessionLayer.onFixTradingSessionStatus( msg );
		applicationLayer.onFixTradingSessionStatus( msg );
	}

	@Override
	public void onFixMassQuote( FixMassQuote msg ) {
		sessionLayer.onFixMassQuote( msg );
		applicationLayer.onFixMassQuote( msg );
	}

	@Override
	public void onFixBusinessMessageReject( FixBusinessMessageReject msg ) {
		sessionLayer.onFixBusinessMessageReject( msg );
		applicationLayer.onFixBusinessMessageReject( msg );
	}

	@Override
	public void onFixBidRequest( FixBidRequest msg ) {
		sessionLayer.onFixBidRequest( msg );
		applicationLayer.onFixBidRequest( msg );
	}

	@Override
	public void onFixBidResponse( FixBidResponse msg ) {
		sessionLayer.onFixBidResponse( msg );
		applicationLayer.onFixBidResponse( msg );
	}

	@Override
	public void onFixListStrikePrice( FixListStrikePrice msg ) {
		sessionLayer.onFixListStrikePrice( msg );
		applicationLayer.onFixListStrikePrice( msg );
	}

	@Override
	public void onFixRegistrationInstructions( FixRegistrationInstructions msg ) {
		sessionLayer.onFixRegistrationInstructions( msg );
		applicationLayer.onFixRegistrationInstructions( msg );
	}

	@Override
	public void onFixRegistrationInstructionsResponse( FixRegistrationInstructionsResponse msg ) {
		sessionLayer.onFixRegistrationInstructionsResponse( msg );
		applicationLayer.onFixRegistrationInstructionsResponse( msg );
	}

	@Override
	public void onFixOrderMassCancelRequest( FixOrderMassCancelRequest msg ) {
		sessionLayer.onFixOrderMassCancelRequest( msg );
		applicationLayer.onFixOrderMassCancelRequest( msg );
	}

	@Override
	public void onFixOrderMassCancelReport( FixOrderMassCancelReport msg ) {
		sessionLayer.onFixOrderMassCancelReport( msg );
		applicationLayer.onFixOrderMassCancelReport( msg );
	}

	@Override
	public void onFixNewOrderCross( FixNewOrderCross msg ) {
		sessionLayer.onFixNewOrderCross( msg );
		applicationLayer.onFixNewOrderCross( msg );
	}

	@Override
	public void onFixCrossOrderCancelReplaceRequest( FixCrossOrderCancelReplaceRequest msg ) {
		sessionLayer.onFixCrossOrderCancelReplaceRequest( msg );
		applicationLayer.onFixCrossOrderCancelReplaceRequest( msg );
	}

	@Override
	public void onFixCrossOrderCancelRequest( FixCrossOrderCancelRequest msg ) {
		sessionLayer.onFixCrossOrderCancelRequest( msg );
		applicationLayer.onFixCrossOrderCancelRequest( msg );
	}

	@Override
	public void onFixSecurityTypeRequest( FixSecurityTypeRequest msg ) {
		sessionLayer.onFixSecurityTypeRequest( msg );
		applicationLayer.onFixSecurityTypeRequest( msg );
	}

	@Override
	public void onFixSecurityTypes( FixSecurityTypes msg ) {
		sessionLayer.onFixSecurityTypes( msg );
		applicationLayer.onFixSecurityTypes( msg );
	}

	@Override
	public void onFixSecurityListRequest( FixSecurityListRequest msg ) {
		sessionLayer.onFixSecurityListRequest( msg );
		applicationLayer.onFixSecurityListRequest( msg );
	}

	@Override
	public void onFixSecurityList( FixSecurityList msg ) {
		sessionLayer.onFixSecurityList( msg );
		applicationLayer.onFixSecurityList( msg );
	}

	@Override
	public void onFixDerivativeSecurityListRequest( FixDerivativeSecurityListRequest msg ) {
		sessionLayer.onFixDerivativeSecurityListRequest( msg );
		applicationLayer.onFixDerivativeSecurityListRequest( msg );
	}

	@Override
	public void onFixDerivativeSecurityList( FixDerivativeSecurityList msg ) {
		sessionLayer.onFixDerivativeSecurityList( msg );
		applicationLayer.onFixDerivativeSecurityList( msg );
	}

	@Override
	public void onFixNewOrderMultileg( FixNewOrderMultileg msg ) {
		sessionLayer.onFixNewOrderMultileg( msg );
		applicationLayer.onFixNewOrderMultileg( msg );
	}

	@Override
	public void onFixMultilegOrderCancelReplace( FixMultilegOrderCancelReplace msg ) {
		sessionLayer.onFixMultilegOrderCancelReplace( msg );
		applicationLayer.onFixMultilegOrderCancelReplace( msg );
	}

	@Override
	public void onFixTradeCaptureReportRequest( FixTradeCaptureReportRequest msg ) {
		sessionLayer.onFixTradeCaptureReportRequest( msg );
		applicationLayer.onFixTradeCaptureReportRequest( msg );
	}

	@Override
	public void onFixTradeCaptureReport( FixTradeCaptureReport msg ) {
		sessionLayer.onFixTradeCaptureReport( msg );
		applicationLayer.onFixTradeCaptureReport( msg );
	}

	@Override
	public void onFixOrderMassStatusRequest( FixOrderMassStatusRequest msg ) {
		sessionLayer.onFixOrderMassStatusRequest( msg );
		applicationLayer.onFixOrderMassStatusRequest( msg );
	}

	@Override
	public void onFixQuoteRequestReject( FixQuoteRequestReject msg ) {
		sessionLayer.onFixQuoteRequestReject( msg );
		applicationLayer.onFixQuoteRequestReject( msg );
	}

	@Override
	public void onFixRFQRequest( FixRFQRequest msg ) {
		sessionLayer.onFixRFQRequest( msg );
		applicationLayer.onFixRFQRequest( msg );
	}

	@Override
	public void onFixQuoteStatusReport( FixQuoteStatusReport msg ) {
		sessionLayer.onFixQuoteStatusReport( msg );
		applicationLayer.onFixQuoteStatusReport( msg );
	}

	@Override
	public void onFixQuoteResponse( FixQuoteResponse msg ) {
		sessionLayer.onFixQuoteResponse( msg );
		applicationLayer.onFixQuoteResponse( msg );
	}

	@Override
	public void onFixConfirmation( FixConfirmation msg ) {
		sessionLayer.onFixConfirmation( msg );
		applicationLayer.onFixConfirmation( msg );
	}

	@Override
	public void onFixPositionMaintenanceRequest( FixPositionMaintenanceRequest msg ) {
		sessionLayer.onFixPositionMaintenanceRequest( msg );
		applicationLayer.onFixPositionMaintenanceRequest( msg );
	}

	@Override
	public void onFixPositionMaintenanceReport( FixPositionMaintenanceReport msg ) {
		sessionLayer.onFixPositionMaintenanceReport( msg );
		applicationLayer.onFixPositionMaintenanceReport( msg );
	}

	@Override
	public void onFixRequestForPositions( FixRequestForPositions msg ) {
		sessionLayer.onFixRequestForPositions( msg );
		applicationLayer.onFixRequestForPositions( msg );
	}

	@Override
	public void onFixRequestForPositionsAck( FixRequestForPositionsAck msg ) {
		sessionLayer.onFixRequestForPositionsAck( msg );
		applicationLayer.onFixRequestForPositionsAck( msg );
	}

	@Override
	public void onFixPositionReport( FixPositionReport msg ) {
		sessionLayer.onFixPositionReport( msg );
		applicationLayer.onFixPositionReport( msg );
	}

	@Override
	public void onFixTradeCaptureReportRequestAck( FixTradeCaptureReportRequestAck msg ) {
		sessionLayer.onFixTradeCaptureReportRequestAck( msg );
		applicationLayer.onFixTradeCaptureReportRequestAck( msg );
	}

	@Override
	public void onFixTradeCaptureReportAck( FixTradeCaptureReportAck msg ) {
		sessionLayer.onFixTradeCaptureReportAck( msg );
		applicationLayer.onFixTradeCaptureReportAck( msg );
	}

	@Override
	public void onFixAllocationReport( FixAllocationReport msg ) {
		sessionLayer.onFixAllocationReport( msg );
		applicationLayer.onFixAllocationReport( msg );
	}

	@Override
	public void onFixAllocationReportAck( FixAllocationReportAck msg ) {
		sessionLayer.onFixAllocationReportAck( msg );
		applicationLayer.onFixAllocationReportAck( msg );
	}

	@Override
	public void onFixConfirmation_Ack( FixConfirmation_Ack msg ) {
		sessionLayer.onFixConfirmation_Ack( msg );
		applicationLayer.onFixConfirmation_Ack( msg );
	}

	@Override
	public void onFixSettlementInstructionRequest( FixSettlementInstructionRequest msg ) {
		sessionLayer.onFixSettlementInstructionRequest( msg );
		applicationLayer.onFixSettlementInstructionRequest( msg );
	}

	@Override
	public void onFixAssignmentReport( FixAssignmentReport msg ) {
		sessionLayer.onFixAssignmentReport( msg );
		applicationLayer.onFixAssignmentReport( msg );
	}

	@Override
	public void onFixCollateralRequest( FixCollateralRequest msg ) {
		sessionLayer.onFixCollateralRequest( msg );
		applicationLayer.onFixCollateralRequest( msg );
	}

	@Override
	public void onFixCollateralAssignment( FixCollateralAssignment msg ) {
		sessionLayer.onFixCollateralAssignment( msg );
		applicationLayer.onFixCollateralAssignment( msg );
	}

	@Override
	public void onFixCollateralResponse( FixCollateralResponse msg ) {
		sessionLayer.onFixCollateralResponse( msg );
		applicationLayer.onFixCollateralResponse( msg );
	}

	@Override
	public void onFixCollateralReport( FixCollateralReport msg ) {
		sessionLayer.onFixCollateralReport( msg );
		applicationLayer.onFixCollateralReport( msg );
	}

	@Override
	public void onFixCollateralInquiry( FixCollateralInquiry msg ) {
		sessionLayer.onFixCollateralInquiry( msg );
		applicationLayer.onFixCollateralInquiry( msg );
	}

	@Override
	public void onFixNetworkCounterpartySystemStatusRequest( FixNetworkCounterpartySystemStatusRequest msg ) {
		sessionLayer.onFixNetworkCounterpartySystemStatusRequest( msg );
		applicationLayer.onFixNetworkCounterpartySystemStatusRequest( msg );
	}

	@Override
	public void onFixNetworkCounterpartySystemStatusResponse( FixNetworkCounterpartySystemStatusResponse msg ) {
		sessionLayer.onFixNetworkCounterpartySystemStatusResponse( msg );
		applicationLayer.onFixNetworkCounterpartySystemStatusResponse( msg );
	}

	@Override
	public void onFixUserRequest( FixUserRequest msg ) {
		sessionLayer.onFixUserRequest( msg );
		applicationLayer.onFixUserRequest( msg );
	}

	@Override
	public void onFixUserResponse( FixUserResponse msg ) {
		sessionLayer.onFixUserResponse( msg );
		applicationLayer.onFixUserResponse( msg );
	}

	@Override
	public void onFixCollateralInquiryAck( FixCollateralInquiryAck msg ) {
		sessionLayer.onFixCollateralInquiryAck( msg );
		applicationLayer.onFixCollateralInquiryAck( msg );
	}

	@Override
	public void onFixConfirmationRequest( FixConfirmationRequest msg ) {
		sessionLayer.onFixConfirmationRequest( msg );
		applicationLayer.onFixConfirmationRequest( msg );
	}

	@Override
	public void onFixContraryIntentionReport( FixContraryIntentionReport msg ) {
		sessionLayer.onFixContraryIntentionReport( msg );
		applicationLayer.onFixContraryIntentionReport( msg );
	}

	@Override
	public void onFixSecurityDefinitionUpdateReport( FixSecurityDefinitionUpdateReport msg ) {
		sessionLayer.onFixSecurityDefinitionUpdateReport( msg );
		applicationLayer.onFixSecurityDefinitionUpdateReport( msg );
	}

	@Override
	public void onFixSecurityListUpdateReport( FixSecurityListUpdateReport msg ) {
		sessionLayer.onFixSecurityListUpdateReport( msg );
		applicationLayer.onFixSecurityListUpdateReport( msg );
	}

	@Override
	public void onFixAdjustedPositionReport( FixAdjustedPositionReport msg ) {
		sessionLayer.onFixAdjustedPositionReport( msg );
		applicationLayer.onFixAdjustedPositionReport( msg );
	}

	@Override
	public void onFixAllocationInstructionAlert( FixAllocationInstructionAlert msg ) {
		sessionLayer.onFixAllocationInstructionAlert( msg );
		applicationLayer.onFixAllocationInstructionAlert( msg );
	}

	@Override
	public void onFixExecutionAcknowledgement( FixExecutionAcknowledgement msg ) {
		sessionLayer.onFixExecutionAcknowledgement( msg );
		applicationLayer.onFixExecutionAcknowledgement( msg );
	}

	@Override
	public void onFixTradingSessionList( FixTradingSessionList msg ) {
		sessionLayer.onFixTradingSessionList( msg );
		applicationLayer.onFixTradingSessionList( msg );
	}

	@Override
	public void onFixTradingSessionListRequest( FixTradingSessionListRequest msg ) {
		sessionLayer.onFixTradingSessionListRequest( msg );
		applicationLayer.onFixTradingSessionListRequest( msg );
	}

	@Override
	public void onFixSettlementObligationReport( FixSettlementObligationReport msg ) {
		sessionLayer.onFixSettlementObligationReport( msg );
		applicationLayer.onFixSettlementObligationReport( msg );
	}

	@Override
	public void onFixDerivativeSecurityListUpdateReport( FixDerivativeSecurityListUpdateReport msg ) {
		sessionLayer.onFixDerivativeSecurityListUpdateReport( msg );
		applicationLayer.onFixDerivativeSecurityListUpdateReport( msg );
	}

	@Override
	public void onFixTradingSessionListUpdateReport( FixTradingSessionListUpdateReport msg ) {
		sessionLayer.onFixTradingSessionListUpdateReport( msg );
		applicationLayer.onFixTradingSessionListUpdateReport( msg );
	}

	@Override
	public void onFixMarketDefinitionRequest( FixMarketDefinitionRequest msg ) {
		sessionLayer.onFixMarketDefinitionRequest( msg );
		applicationLayer.onFixMarketDefinitionRequest( msg );
	}

	@Override
	public void onFixMarketDefinition( FixMarketDefinition msg ) {
		sessionLayer.onFixMarketDefinition( msg );
		applicationLayer.onFixMarketDefinition( msg );
	}

	@Override
	public void onFixMarketDefinitionUpdateReport( FixMarketDefinitionUpdateReport msg ) {
		sessionLayer.onFixMarketDefinitionUpdateReport( msg );
		applicationLayer.onFixMarketDefinitionUpdateReport( msg );
	}

	@Override
	public void onFixUserNotification( FixUserNotification msg ) {
		sessionLayer.onFixUserNotification( msg );
		applicationLayer.onFixUserNotification( msg );
	}

	@Override
	public void onFixOrderMassActionReport( FixOrderMassActionReport msg ) {
		sessionLayer.onFixOrderMassActionReport( msg );
		applicationLayer.onFixOrderMassActionReport( msg );
	}

	@Override
	public void onFixOrderMassActionRequest( FixOrderMassActionRequest msg ) {
		sessionLayer.onFixOrderMassActionRequest( msg );
		applicationLayer.onFixOrderMassActionRequest( msg );
	}

	@Override
	public void onFixApplicationMessageRequest( FixApplicationMessageRequest msg ) {
		sessionLayer.onFixApplicationMessageRequest( msg );
		applicationLayer.onFixApplicationMessageRequest( msg );
	}

	@Override
	public void onFixApplicationMessageRequestAck( FixApplicationMessageRequestAck msg ) {
		sessionLayer.onFixApplicationMessageRequestAck( msg );
		applicationLayer.onFixApplicationMessageRequestAck( msg );
	}

	@Override
	public void onFixApplicationMessageReport( FixApplicationMessageReport msg ) {
		sessionLayer.onFixApplicationMessageReport( msg );
		applicationLayer.onFixApplicationMessageReport( msg );
	}

	@Override
	public void onFixStreamAssignmentRequest( FixStreamAssignmentRequest msg ) {
		sessionLayer.onFixStreamAssignmentRequest( msg );
		applicationLayer.onFixStreamAssignmentRequest( msg );
	}

	@Override
	public void onFixStreamAssignmentReport( FixStreamAssignmentReport msg ) {
		sessionLayer.onFixStreamAssignmentReport( msg );
		applicationLayer.onFixStreamAssignmentReport( msg );
	}

	@Override
	public void onFixStreamAssignmentReportACK( FixStreamAssignmentReportACK msg ) {
		sessionLayer.onFixStreamAssignmentReportACK( msg );
		applicationLayer.onFixStreamAssignmentReportACK( msg );
	}

	@Override
	public void onFixPartyDetailsListRequest( FixPartyDetailsListRequest msg ) {
		sessionLayer.onFixPartyDetailsListRequest( msg );
		applicationLayer.onFixPartyDetailsListRequest( msg );
	}

	@Override
	public void onFixPartyDetailsListReport( FixPartyDetailsListReport msg ) {
		sessionLayer.onFixPartyDetailsListReport( msg );
		applicationLayer.onFixPartyDetailsListReport( msg );
	}

}
