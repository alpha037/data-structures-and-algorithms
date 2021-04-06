package AlgoExSolutions.Hard.LowestCommonManager;

import java.util.*;

/**
 * * Lowest Common Manager
 */
class Program {
  /**
   * * TC: O(n)
   * * SC: O(d)
   */
  public static OrgChart getLowestCommonManager(
      OrgChart topManager, OrgChart reportOne, OrgChart reportTwo) {
    // Write your code here.
    return getOrgInfo(topManager, reportOne, reportTwo).lowestCommonManager;
  }

  private static OrgInfo getOrgInfo(
      OrgChart currentManager, OrgChart reportOne, OrgChart reportTwo) {
    int numberOfImpReports = 0;

    for (OrgChart directReport : currentManager.directReports) {
      OrgInfo orgInfo = getOrgInfo(directReport, reportOne, reportTwo);
      if (orgInfo.lowestCommonManager != null) return orgInfo;

      numberOfImpReports += orgInfo.numberOfImpReports;
    }

    numberOfImpReports += currentManager == reportOne || currentManager == reportTwo ? 1 : 0;
    OrgChart lowestCommonManager = numberOfImpReports == 2 ? currentManager : null;

    return new OrgInfo(lowestCommonManager, numberOfImpReports);
  }

  static class OrgChart {
    public char name;
    public List<OrgChart> directReports;

    OrgChart(char name) {
      this.name = name;
      this.directReports = new ArrayList<OrgChart>();
    }

    // This method is for testing only.
    public void addDirectReports(OrgChart[] directReports) {
      for (OrgChart directReport : directReports) {
        this.directReports.add(directReport);
      }
    }
  }

  static class OrgInfo {
    OrgChart lowestCommonManager;
    int numberOfImpReports;

    public OrgInfo(OrgChart lowestCommonManager, int numberOfImpReports) {
      this.lowestCommonManager = lowestCommonManager;
      this.numberOfImpReports = numberOfImpReports;
    }
  }
}
